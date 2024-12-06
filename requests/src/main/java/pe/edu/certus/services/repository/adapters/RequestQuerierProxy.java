package pe.edu.certus.services.repository.adapters;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.certus.services.business.ports.drivens.ForManagingRequest;
import pe.edu.certus.services.business.domain.RequestModel;
import pe.edu.certus.services.repository.ports.drivers.ForQueryingRequest;
import pe.edu.certus.services.repository.entity.RequestEntity;

import java.util.List;
import java.util.Optional;

@Service
public class RequestQuerierProxy implements ForManagingRequest {
    private final ForQueryingRequest forQueryingRequest;

    public RequestQuerierProxy(ForQueryingRequest forQueryingRequest) {
        this.forQueryingRequest = forQueryingRequest;
    }

    @Override
    @Transactional
    public void saveRequest(RequestModel requestModel) {
        forQueryingRequest.save(RequestEntityMapper.toEntity(requestModel));
    }

    @Override
    public List<RequestModel> getAllRequests() {
        List<RequestEntity> requestEntities = forQueryingRequest.findAll();
        return RequestEntityMapper.toModelEntities(requestEntities);
    }

    @Override
    @Transactional
    public RequestModel updateRequest(RequestModel requestModel) {
        RequestEntity requestEntity = RequestEntityMapper.toEntity(requestModel);
        RequestEntity updatedEntity = forQueryingRequest.save(requestEntity);
        return RequestEntityMapper.toModelEntity(updatedEntity);
    }

    @Override
    public RequestModel getRequestById(Long id) {
        Optional<RequestEntity> requestEntity = forQueryingRequest.findById(id);
        return requestEntity.map(RequestEntityMapper::toModelEntity).orElse(null);
    }

    @Override
    @Transactional
    public void deleteRequestById(Long id) {
        forQueryingRequest.deleteById(id);
    }
}
