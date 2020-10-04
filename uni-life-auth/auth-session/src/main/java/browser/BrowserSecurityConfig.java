package browser;

import com.uni.life.auth.core.AbstractChannelSecurityConfig;
import com.uni.life.auth.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.uni.life.auth.core.enums.SecurityConstants;
import com.uni.life.auth.core.properties.NrscSecurityProperties;
import com.uni.life.auth.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {

    @Autowired
    private NrscSecurityProperties nrscSecurityProperties;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService NRSCDetailsService;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;


    /**
     * @see SocialConfig#nrscSocialSecurityConfig()
     */
    @Autowired
    private SpringSocialConfigurer nrscSocialSecurityConfig;

    /**
     * session失效策略
     */
    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;
    /***
     * session并发策略
     */
    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    /**退出成功处理器*/
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        // tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        applyPasswordAuthenticationConfig(http);
        http.apply(validateCodeSecurityConfig)
                .and()
                    //短信校验相关配置
                    .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                    //springsocial校验相关配置
                    .apply(nrscSocialSecurityConfig)
                .and()
                    //记住我相关配置
                    .rememberMe()
                        .tokenRepository(persistentTokenRepository())
                        .tokenValiditySeconds(nrscSecurityProperties.getBrowser().getRememberMeSeconds())
                        .userDetailsService(NRSCDetailsService)
                .and()
                    //session相关的控制
                    .sessionManagement()
                        //指定session失效策略
                        .invalidSessionStrategy(invalidSessionStrategy)
                         //指定最大的session并发数量---即一个用户只能同时在一处登陆（腾讯视频的账号好像就只能同时允许2-3个手机同时登陆）
                        .maximumSessions(nrscSecurityProperties.getBrowser().getSession().getMaximumSessions())
                        //当超过指定的最大session并发数量时，阻止后面的登陆（感觉貌似很少会用到这种策略）
                        .maxSessionsPreventsLogin(nrscSecurityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())
                        //超过最大session并发数量时的策略
                        .expiredSessionStrategy(sessionInformationExpiredStrategy)
                .and()
                .and()
                //退出登陆相关的逻辑
                    .logout()
                    //自定义退出的url---默认的为/logout
                    .logoutUrl("/signOut")
                    //自定义退出成功处理器
                    .logoutSuccessHandler(logoutSuccessHandler)
                    //自定义退出成功后跳转的url与logoutSuccessHandler互斥
                    //.logoutSuccessUrl("/index")
                    //指定退出成功后删除的cookie
                    .deleteCookies("JSESSIONID")
                .and()
                    .authorizeRequests()
                    //配置不用进行认证校验的url
                    .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        nrscSecurityProperties.getBrowser().getLoginPage(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        nrscSecurityProperties.getBrowser().getSignUpUrl(),
                        //session失效默认的跳转地址
                        nrscSecurityProperties.getBrowser().getSession().getSessionInvalidUrl(),
                        //获取第三方账号的用户信息的默认url----微信、QQ登陆没找到与本系统的关联关系时用到---此时没登陆
                        SecurityConstants.DEFAULT_GET_SOCIAL_USERINFO_URL,
                        //退出登陆默认跳转的url
                        nrscSecurityProperties.getBrowser().getSignOutUrl(),
                        "/user/register",
                        "/js/**",
                        "/swagger-ui.html",
                        "/swagger-ui.html/**",
                        "/webjars/**", "/swagger-resources/**", "/v2/**","/configuration/**"
                    )
                    .permitAll()
                    .antMatchers(HttpMethod.GET,"/user/*").hasRole("ADMIN")
                    //指明除了上面不用认证的url外其他请求都需要认证校验
                    .anyRequest()
                    .authenticated()
                //关闭csrf
                .and()
                    .csrf().disable();
    }


}
