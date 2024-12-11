package pe.edu.certus.services.business.adapters.drivens;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pe.edu.certus.services.business.model.NotificationModel;
import pe.edu.certus.services.business.ports.drivens.ForManagingNotificationSender;

@Component
@RequiredArgsConstructor
public class KafkaNotificationProxy implements ForManagingNotificationSender {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendNotification(NotificationModel notification) {
        // Default implementation - can be expanded
        sendNotificationToTopic("default-notification-topic", notification);
    }

    @Override
    public void sendNotificationToTopic(String topic, NotificationModel notification) {
        // Convert notification to JSON or appropriate format
        String message = convertNotificationToMessage(notification);
        kafkaTemplate.send(topic, notification.getId(), message);
    }

    private String convertNotificationToMessage(NotificationModel notification) {
        // Implement JSON conversion or use a serialization library
        return notification.toString();
    }
}
