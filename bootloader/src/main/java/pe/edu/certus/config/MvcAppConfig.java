//package pe.edu.certus.config;
//
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@ComponentScan(basePackages = {
//        "pe.edu.certus.services.business.adapters.drivers",
//        "pe.edu.certus.services.business.adapter.drivens",
//        "pe.edu.certus.services.repository.adapters.drivers"
//})
//@EntityScan("pe.edu.certus.services.repository.entity")
//@EnableJpaRepositories("pe.edu.certus.services.repository.ports.drivers")
//public class MvcAppConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/")
//                .setCachePeriod(0);
//    }
//}
