package pe.edu.certus.services.business.adapters.drivers;

import pe.edu.certus.services.business.domain.RequestModel;

public class RequestWebConverter {
    protected static RequestWebModel fromDomainModel(RequestModel requestModel){
        return new RequestWebModel(
                requestModel.getId(),
                requestModel.getCategory(),
                requestModel.getDescription(),
                requestModel.getStatus()
        );
    }

    protected static RequestModel toDomainModel(RequestWebModel requestWebModel){
        return new RequestModel(
                requestWebModel.id(),
                requestWebModel.category(),
                requestWebModel.description(),
                requestWebModel.status()
        );
    }
}
