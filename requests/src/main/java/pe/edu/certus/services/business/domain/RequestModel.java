package pe.edu.certus.services.business.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestModel {

    private Long id;
    private String category;
    private String description;
    private Boolean status;
    
}
