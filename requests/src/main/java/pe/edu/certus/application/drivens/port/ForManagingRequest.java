package pe.edu.certus.application.drivens.port;

import pe.edu.certus.domain.model.RequestPOJO;

import java.util.List;

public interface ForManagingRequest {

    void saveRequest(RequestPOJO requestPOJO);
    List<RequestPOJO> getAllRequests();
    RequestPOJO getRequestById(Long requestModel);
    RequestPOJO updateRequest(RequestPOJO requestPOJO);
    void deleteRequestById(Long id);

}
