package pe.edu.certus.services.business.model;


import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationModel {
    private String id;
    private String type; // e.g., "REQUEST_STATUS_CHANGE"
    private String content;
    private String recipient;
    private LocalDateTime timestamp;
    private boolean read;
    
    // Request-specific details
    private Long requestId;
    private String requestType; // e.g., "VIATICOS"
    private boolean requestStatus; // true for accepted, false for pending/rejected
    private String approverName;
}