package pe.edu.certus.services.business.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.certus.services.business.model.NotificationModel;
import pe.edu.certus.services.business.ports.drivens.ForManagingNotificationSender;

@Service
@RequiredArgsConstructor
public class NotificationService implements ForManagingNotificationSender {
    @Override
    public void sendNotification(NotificationModel notification) {
        // In a real-world scenario, this would use WebSocket or message broker
        // For now, we'll just log the notification
        System.out.println("Notification sent: " + notification);
    }

    @Override
    public void sendNotificationToTopic(String topic, NotificationModel notification) {
        // Similar to sendNotification, but with a specific topic
        System.out.println("Notification sent to topic " + topic + ": " + notification);
    }
}
