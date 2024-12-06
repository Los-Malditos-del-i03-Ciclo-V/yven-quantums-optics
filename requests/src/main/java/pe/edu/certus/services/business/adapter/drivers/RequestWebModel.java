package pe.edu.certus.services.business.adapter.drivers;


import pe.edu.certus.services.business.domain.RequestModel;

public record RequestWebModel(Long id,
                              String category,
                              String description,
                              Boolean status) {

    public static RequestWebModel fromDomainModel(RequestModel requestModel){
        return new RequestWebModel(
                requestModel.getId(),
                requestModel.getCategory(),
                requestModel.getDescription(),
                requestModel.getStatus()
        );
    }

    public static RequestModel toDomainModel(RequestWebModel requestWebModel){
        return new RequestModel(
                requestWebModel.id(),
                requestWebModel.category(),
                requestWebModel.description(),
                requestWebModel.status()
        );
    }
}
