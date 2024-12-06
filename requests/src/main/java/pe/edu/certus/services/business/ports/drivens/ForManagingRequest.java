package pe.edu.certus.services.business.ports.drivens;

import pe.edu.certus.services.business.domain.RequestModel;

import java.util.List;

public interface ForManagingRequest {

    void saveRequest(RequestModel requestModel);
    List<RequestModel> getAllRequests();
    RequestModel getRequestById(Long requestModel);
    RequestModel updateRequest(RequestModel requestModel);
    void deleteRequestById(Long id);

}
