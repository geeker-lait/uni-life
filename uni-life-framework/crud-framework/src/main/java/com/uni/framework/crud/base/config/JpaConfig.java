package com.uni.framework.crud.base.config;

import com.uni.framework.crud.base.utils.UserUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * 开启jpa自动填充创建人、创建时间、更新人、更新时间的配置
 *
 */
@Configuration
@EnableJpaAuditing
public class JpaConfig {

    /**
     * 实现AuditorAware接口，这样才会填充创建和更新的操作人
     *
     * @return
     */
    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAware<String>() {
            @Override
            public Optional<String> getCurrentAuditor() {
                return Optional.ofNullable(UserUtils.getCurrentUser());
            }
        };
    }
}
