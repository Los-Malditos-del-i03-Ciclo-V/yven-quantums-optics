package pe.edu.certus.services.business.adapters.drivens;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.certus.services.business.model.NotificationModel;
import pe.edu.certus.services.business.ports.drivens.ForManagingNotification;
import pe.edu.certus.services.business.ports.drivens.ForManagingNotificationSender;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationSenderManager implements ForManagingNotification {
    private final ForManagingNotificationSender notificationSender;
    
    // In-memory storage for demonstration - replace with actual database in production
    private final Map<String, NotificationModel> notificationStore = new HashMap<>();

    @Override
    public void saveNotification(NotificationModel notification) {
        if (notification.getId() == null) {
            notification.setId(UUID.randomUUID().toString());
        }
        if (notification.getTimestamp() == null) {
            notification.setTimestamp(LocalDateTime.now());
        }
        notification.setRead(false);
        
        notificationStore.put(notification.getId(), notification);
        notificationSender.sendNotification(notification);
    }

    @Override
    public NotificationModel findNotificationById(String id) {
        return notificationStore.get(id);
    }
}
