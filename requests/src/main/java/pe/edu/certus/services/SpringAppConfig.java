package pe.edu.certus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import pe.edu.certus.services.business.adapter.drivens.RequestManager;
import pe.edu.certus.services.business.ports.drivens.ForManagingRequest;
import pe.edu.certus.services.business.ports.drivers.ForRequest;

/**
 * 
 */
@SpringBootApplication
public class SpringAppConfig {

    @Autowired
    ForManagingRequest forManagingRequest;

    @Bean
    @Primary
    ForRequest forRequestModel() {
        return new RequestManager(forManagingRequest);
    }

}
