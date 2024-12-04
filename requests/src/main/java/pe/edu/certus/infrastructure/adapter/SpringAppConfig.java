package pe.edu.certus.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pe.edu.certus.application.drivers.adapters.RequestManager;
import pe.edu.certus.application.drivers.port.ForRequest;
import pe.edu.certus.application.drivens.port.ForManagingRequest;

@SpringBootApplication
public class SpringAppConfig {

    @Autowired
    ForManagingRequest forManagingRequest;

    @Bean
    ForRequest forRequestModel() {
        return new RequestManager(forManagingRequest);
    }

}
