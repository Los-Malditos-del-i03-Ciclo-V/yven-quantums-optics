package pe.edu.certus.application.drivers.port;

import java.util.List;

public interface ForRequest<RequestPOJO, Long>{

    void createRequestModel( RequestPOJO requestPO);
    RequestPOJO findRequestModelById(Long id);
    List<RequestPOJO> findAllRequestModel();
    RequestPOJO updateRequestModel(RequestPOJO requestPO);
    void deleteRequestModelById(Long id);

}
