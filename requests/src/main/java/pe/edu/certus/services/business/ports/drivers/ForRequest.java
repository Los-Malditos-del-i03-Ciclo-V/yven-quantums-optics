package pe.edu.certus.services.business.ports.drivers;

import java.util.List;

public interface ForRequest<RequestModel, Long>{

    void createRequestModel( RequestModel requestPO);
    RequestModel findRequestModelById(Long id);
    List<RequestModel> findAllRequestModel();
    RequestModel updateRequestModel(RequestModel requestPO);
    void deleteRequestModelById(Long id);

}
