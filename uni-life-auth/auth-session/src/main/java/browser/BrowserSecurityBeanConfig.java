package browser;

import browser.logout.NRSCLogoutSuccessHandler;
import browser.session.NRSCExpiredSessionStrategy;
import browser.session.NRSCInvalidSessionStrategy;
import com.uni.life.auth.core.properties.NrscSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * @date : 2019/9/21 21:01
 * Description：
 */
@Configuration
public class BrowserSecurityBeanConfig {

    @Autowired
    private NrscSecurityProperties nrscSecurityProperties;

    @Bean
    //用户可以通过实现一个InvalidSessionStrategy类型的bean来覆盖掉默认的实现--》NRSCInvalidSessionStrategy
    @ConditionalOnMissingBean(InvalidSessionStrategy.class)
    public InvalidSessionStrategy invalidSessionStrategy(){
        return new NRSCInvalidSessionStrategy(nrscSecurityProperties.getBrowser().getSession().getSessionInvalidUrl());
    }

    @Bean
    @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
        return new NRSCExpiredSessionStrategy(nrscSecurityProperties.getBrowser().getSession().getSessionInvalidUrl());
    }

    @Bean
    @ConditionalOnMissingBean(LogoutSuccessHandler.class)
    public LogoutSuccessHandler logoutSuccessHandler(){
        return new NRSCLogoutSuccessHandler(nrscSecurityProperties.getBrowser().getSignOutUrl());
    }
}
