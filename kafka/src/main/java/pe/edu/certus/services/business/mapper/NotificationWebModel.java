package pe.edu.certus.services.business.mapper;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotificationWebModel {
    private String id;
    private String type;
    private String content;
    private String recipient;
    private LocalDateTime timestamp;
    private boolean read;
    
    // Request-specific details
    private Long requestId;
    private String requestType;
    private boolean requestStatus;
    private String approverName;
}
