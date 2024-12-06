package pe.edu.certus.services.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pe.edu.certus.services.business.ports.drivens.ForManagingRequest;
import pe.edu.certus.services.business.adapters.drivens.RequestManager;
import pe.edu.certus.services.business.ports.drivers.ForRequest;


@SpringBootApplication
public class SpringAppConfig {

    @Autowired
    ForManagingRequest forManagingRequest;

    @Bean
    ForRequest forRequestModel() {
        return new RequestManager(forManagingRequest);
    }

}
