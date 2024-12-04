package pe.edu.certus.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestPOJO {

    private Long id;
    private String category;
    private String description;
    private Boolean status;
    
}
