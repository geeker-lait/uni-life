package com.uni.life.crud.config;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.uni.life.crud.xss.StringXssDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/***
 * spring mvc相关配置
 *
 */
@Configuration
public class WebMvcConfig {

    /**
     * 替换默认的转换器,用于防御XSS攻击
     *
     * @return
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter htmlEscapingConverter = new MappingJackson2HttpMessageConverter();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(String.class, new StringXssDeserializer());
        htmlEscapingConverter.getObjectMapper().registerModule(simpleModule);
        return htmlEscapingConverter;
    }
}
