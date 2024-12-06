package pe.edu.certus.services.repository.adapters.drivers;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.certus.services.business.model.OperatorModel;
import pe.edu.certus.services.business.ports.drivens.ForManagingOperator;
import pe.edu.certus.services.repository.entity.OperatorEntity;
import pe.edu.certus.services.repository.ports.drivers.ForQueryingOperator;

import java.util.List;
import java.util.Optional;

@Service
public class OperatorQuerierProxy implements ForManagingOperator {

    private final ForQueryingOperator forQueryingOperator;


    public OperatorQuerierProxy(ForQueryingOperator forQueryingOperator) {
        this.forQueryingOperator = forQueryingOperator;
    }

    @Override
    @Transactional
    public void saveOperator(OperatorModel operatorModel) {
        forQueryingOperator.save(OperatorMapper.toEntity(operatorModel));
    }

    @Override
    public List<OperatorModel> getAllOperators() {
        List<OperatorEntity> operatorEntities = forQueryingOperator.findAll();
        return OperatorMapper.toModelEntities(operatorEntities);
    }

    @Override
    public OperatorModel getOperatorById(Long id) {
        Optional<OperatorEntity> operatorEntity = forQueryingOperator.findById(id);
        return operatorEntity.map(OperatorMapper::toModelEntity)
                .orElse(null);
    }

    @Override
    @Transactional
    public OperatorModel updateOperator(OperatorModel operatorModel) {
        OperatorEntity operatorEntity = OperatorMapper.toEntity(operatorModel);
        OperatorEntity updatedEntity = forQueryingOperator.save(operatorEntity);
        return OperatorMapper.toModelEntity(updatedEntity);
    }

    @Override
    @Transactional
    public void deleteOperatorById(Long id) {
        forQueryingOperator.deleteById(id);
    }
}
