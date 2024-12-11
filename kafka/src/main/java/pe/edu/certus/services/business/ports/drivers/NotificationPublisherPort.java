package pe.edu.certus.services.business.ports.drivers;

import pe.edu.certus.services.business.model.NotificationModel;

public interface NotificationPublisherPort {
    void publishNotification(NotificationModel notification);
}
