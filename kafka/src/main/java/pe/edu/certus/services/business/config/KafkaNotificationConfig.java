package pe.edu.certus.services.business.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaNotificationConfig {

    @Bean
    public NewTopic requestNotificationsTopic() {
        return TopicBuilder
            .name("request-notifications")
            .partitions(1)
            .replicas(1)
            .build();
    }
}
