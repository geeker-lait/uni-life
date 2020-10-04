package com.uni.life.auth.core.social.qq.config;

import com.uni.life.auth.core.properties.NrscSecurityProperties;
import com.uni.life.auth.core.properties.QQProperties;
import com.uni.life.auth.core.social.configutils.SocialAutoConfigurerAdapter;
import com.uni.life.auth.core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @date : 2019/8/7 20:38
 * Description:
 */
@Configuration
@ConditionalOnProperty(prefix = "nrsc.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private NrscSecurityProperties nrscSecurityProperties;

    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqConfig = nrscSecurityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
    }

//    @Bean({"connect/weixinConnect", "connect/weixinConnected"})
//    @ConditionalOnMissingBean(name = "weixinConnectedView")
//    public View weixinConnectedView() {
//        return new NrscConnectView();
//    }

}
