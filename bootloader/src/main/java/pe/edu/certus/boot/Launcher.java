package pe.edu.certus.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.certus.config.OperatorAppConfig;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(OperatorAppConfig.class, args);
    }
}
