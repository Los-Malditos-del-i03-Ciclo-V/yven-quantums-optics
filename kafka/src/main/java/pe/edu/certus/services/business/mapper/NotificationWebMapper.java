package pe.edu.certus.services.business.mapper;

import pe.edu.certus.services.business.model.NotificationModel;

public class NotificationWebMapper {
    public static NotificationModel toModel(NotificationWebModel webModel) {
        return NotificationModel.builder()
            .id(webModel.id())
            .type(webModel.type())
            .content(webModel.content())
            .recipient(webModel.recipient())
            .timestamp(webModel.timestamp())
            .read(webModel.read())
            .build();
    }

    public static NotificationWebModel fromModel(NotificationModel model) {
        return NotificationWebModel.builder()
            .id(model.getId())
            .type(model.getType())
            .content(model.getContent())
            .recipient(model.getRecipient())
            .timestamp(model.getTimestamp())
            .read(model.isRead())
            .build();
    }
}
