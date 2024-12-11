package pe.edu.certus.yqo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "pe.edu.certus.yqo", 
    "pe.edu.certus.services", 
    "pe.edu.certus.requests",
    "pe.edu.certus.frontend"
})
public class YvenQuantumOpticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(YvenQuantumOpticsApplication.class, args);
	}

}
