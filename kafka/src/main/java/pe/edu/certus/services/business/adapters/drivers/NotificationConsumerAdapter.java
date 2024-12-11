package pe.edu.certus.services.business.adapters.drivers;

import lombok.RequiredArgsConstructor;
¿import org.springframework.stereotype.Component;
import pe.edu.certus.services.business.ports.drivers.ForNotificationConsumer;

@Component
@RequiredArgsConstructor
public class NotificationConsumerAdapter {
    private final ForNotificationConsumer forNotificationConsumer;

    @KafkaListener(topics = "${kafka.notification.topic}", groupId = "${kafka.consumer.group-id}")
    public void consumeNotification(String message) {
        forNotificationConsumer.consumeNotification(message);
    }
}
