package pe.edu.certus.services.business.adapters.drivers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
public class RequestWebModel{

    private Long id;
    private String category;
    private String description;
    private Boolean status;

}
