package pe.edu.certus.infrastructure.adapter.out;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.certus.application.drivens.port.ForManagingRequest;
import pe.edu.certus.domain.model.RequestPOJO;

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
    public void saveRequest(RequestPOJO requestPOJO) {
        forQueryingRequest.save(RequestMapper.toEntity(requestPOJO));
    }

    @Override
    public List<RequestPOJO> getAllRequests() {
        List<RequestEntity> requestEntities = forQueryingRequest.findAll();
        return RequestMapper.toModelEntities(requestEntities);
    }

    @Override
    @Transactional
    public RequestPOJO updateRequest(RequestPOJO requestPOJO) {
        RequestEntity requestEntity = RequestMapper.toEntity(requestPOJO);
        RequestEntity updatedEntity = forQueryingRequest.save(requestEntity);
        return RequestMapper.toModelEntity(updatedEntity);
    }

    @Override
    public RequestPOJO getRequestById(Long id) {
        Optional<RequestEntity> requestEntity = forQueryingRequest.findById(id);
        return requestEntity.map(RequestMapper::toModelEntity).orElse(null);
    }

    @Override
    @Transactional
    public void deleteRequestById(Long id) {
        forQueryingRequest.deleteById(id);
    }
}
