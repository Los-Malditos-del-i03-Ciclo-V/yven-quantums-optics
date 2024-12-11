package pe.edu.certus.services.business.ports.drivens;

import pe.edu.certus.services.business.model.NotificationModel;

public interface ForManagingNotification {
    void saveNotification(NotificationModel notification);
    NotificationModel findNotificationById(String id);
}
