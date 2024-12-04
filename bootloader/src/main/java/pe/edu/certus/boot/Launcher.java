package pe.edu.certus.boot;

import org.springframework.boot.SpringApplication;
import pe.edu.certus.infrastructure.adapter.SpringAppConfig;

public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(SpringAppConfig.class, args);
    }
}
