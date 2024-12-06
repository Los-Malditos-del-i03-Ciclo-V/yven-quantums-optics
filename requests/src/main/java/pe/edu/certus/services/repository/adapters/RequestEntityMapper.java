package pe.edu.certus.services.repository.adapters;

import pe.edu.certus.services.business.domain.RequestModel;
import pe.edu.certus.services.repository.entity.RequestEntity;

import java.util.List;
import java.util.stream.Collectors;

public class RequestEntityMapper {

    protected static RequestEntity toEntity(RequestModel requestModel) {
        RequestEntity requestEntity = new RequestEntity();

        requestEntity.setId(requestModel.getId());
        requestEntity.setCategory(requestModel.getCategory());
        requestEntity.setDescription(requestModel.getDescription());
        requestEntity.setStatus(requestModel.getStatus());

        return requestEntity;
    }

    protected static RequestModel toModelEntity(RequestEntity requestEntity) {
        return new RequestModel(
                requestEntity.getId(),
                requestEntity.getCategory(),
                requestEntity.getDescription(),
                requestEntity.getStatus()
        );
    }

    protected static List<RequestModel> toModelEntities(List<RequestEntity> requestEntities) {
        return requestEntities.stream()
                .map(RequestEntityMapper::toModelEntity)
                .collect(Collectors.toList());
    }
}
