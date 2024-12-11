package pe.edu.certus.services.business.ports.drivens;

import pe.edu.certus.services.business.model.NotificationModel;

public interface ForManagingNotificationSender {
    void sendNotification(NotificationModel notification);
    void sendNotificationToTopic(String topic, NotificationModel notification);
}
