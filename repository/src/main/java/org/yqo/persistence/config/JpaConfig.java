package org.yqo.persistence.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.yqo.persistence.entity.operador"})
public class JpaConfig {
    // ...
}
