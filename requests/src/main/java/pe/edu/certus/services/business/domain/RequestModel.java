package pe.edu.certus.services.business.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestModel {

    private Long id;
    private String category;
    private String description;
    private Boolean status;
    
}
