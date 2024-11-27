package org.yqo.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"org.yqo.model.operador.entity"})
public class EntityScanConfig {
    // ...
}