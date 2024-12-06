package pe.edu.certus.services.repository.adapters.drivers;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.certus.services.business.domain.RequestModel;
import pe.edu.certus.services.business.ports.drivens.ForManagingRequest;
import pe.edu.certus.services.repository.entity.RequestEntity;
import pe.edu.certus.services.repository.ports.drivers.ForQueryingRequest;

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
        // Para nuevas entidades, asegurarse de que el ID sea null
        requestModel.setId(null);
        RequestEntity entity = RequestMapper.toEntity(requestModel);
        forQueryingRequest.save(entity);
    }

    @Override
    public List<RequestModel> getAllRequests() {
        List<RequestEntity> requestEntities = forQueryingRequest.findAll();
        return RequestMapper.toModelEntities(requestEntities);
    }

    @Override
    @Transactional
    public RequestModel updateRequest(RequestModel requestModel) {
        RequestEntity requestEntity = RequestMapper.toEntity(requestModel);
        RequestEntity updatedEntity = forQueryingRequest.save(requestEntity);
        return RequestMapper.toModelEntity(updatedEntity);
    }

    @Override
    public RequestModel getRequestById(Long id) {
        Optional<RequestEntity> requestEntity = forQueryingRequest.findById(id);
        return requestEntity.map(RequestMapper::toModelEntity).orElse(null);
    }

    @Override
    @Transactional
    public void deleteRequestById(Long id) {
        forQueryingRequest.deleteById(id);
    }
}
