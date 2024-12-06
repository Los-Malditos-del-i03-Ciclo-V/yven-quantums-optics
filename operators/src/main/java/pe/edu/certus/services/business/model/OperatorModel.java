package pe.edu.certus.services.business.model;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class OperatorModel {
    private Long id;
    private String name;
    private String email;
    private String cellphone;
    private Boolean status;
    private Timestamp timestamp;
}
