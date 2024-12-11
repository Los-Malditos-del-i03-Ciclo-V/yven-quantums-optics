package pe.edu.certus.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "pe.edu.certus.services")
@EntityScan("pe.edu.certus.services.repository.entity")
@EnableJpaRepositories("pe.edu.certus.services.repository.ports.drivers")
public class SpringAppConfig {
}
