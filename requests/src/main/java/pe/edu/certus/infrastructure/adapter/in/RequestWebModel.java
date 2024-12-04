package pe.edu.certus.infrastructure.adapter.in;

import pe.edu.certus.domain.model.RequestPOJO;

public record RequestWebModel(Long id,
                              String category,
                              String description,
                              Boolean status) {

    public static RequestWebModel fromDomainModel(RequestPOJO requestPOJO){
        return new RequestWebModel(
                requestPOJO.getId(),
                requestPOJO.getCategory(),
                requestPOJO.getDescription(),
                requestPOJO.getStatus()
        );
    }

    public static RequestPOJO toDomainModel(RequestWebModel requestWebModel){
        return new RequestPOJO(
                requestWebModel.id(),
                requestWebModel.category(),
                requestWebModel.description(),
                requestWebModel.status()
        );
    }
}
