package pe.edu.certus.services.business.adapters.drivers;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pe.edu.certus.services.business.model.NotificationModel;
import pe.edu.certus.services.business.ports.drivers.NotificationPublisherPort;

@Component
@RequiredArgsConstructor
public class NotificationPublisherAdapter implements NotificationPublisherPort {
    private static final String NOTIFICATION_TOPIC = "request-notifications";
    
    private final KafkaTemplate<String, NotificationModel> kafkaTemplate;

    @Override
    public void publishNotification(NotificationModel notification) {
        // Establecer timestamp si no está establecido
        if (notification.getTimestamp() == null) {
            notification.setTimestamp(LocalDateTime.now());
        }
        
        // Publicar en el topic de Kafka
        kafkaTemplate.send(NOTIFICATION_TOPIC, 
            String.valueOf(notification.getRequestId()), 
            notification
        );
        
        // Log de la notificación (opcional)
        System.out.println("Notification published: " + notification);
    }
}
