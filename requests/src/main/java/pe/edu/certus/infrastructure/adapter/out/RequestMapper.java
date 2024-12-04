package pe.edu.certus.infrastructure.adapter.out;

import lombok.NoArgsConstructor;
import org.hibernate.query.Order;
import pe.edu.certus.domain.model.RequestPOJO;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class RequestMapper {

    static RequestEntity toEntity(RequestPOJO requestPOJO) {
        RequestEntity requestEntity = new RequestEntity();

        requestEntity.setId(requestPOJO.getId());
        requestEntity.setCategory(requestPOJO.getCategory());
        requestEntity.setDescription(requestPOJO.getDescription());
        requestEntity.setStatus(requestPOJO.getStatus());

        return requestEntity;
    }

    static RequestPOJO toModelEntity(RequestEntity requestEntity) {
        return new RequestPOJO(
                requestEntity.getId(),
                requestEntity.getCategory(),
                requestEntity.getDescription(),
                requestEntity.getStatus()
        );
    }

    static List<RequestPOJO> toModelEntities(List<RequestEntity> requestEntities) {
        return requestEntities.stream()
                .map(RequestMapper::toModelEntity)
                .collect(Collectors.toList());
    }
}
