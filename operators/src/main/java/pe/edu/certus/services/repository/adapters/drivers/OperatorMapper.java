package pe.edu.certus.services.repository.adapters.drivers;

import lombok.NoArgsConstructor;
import pe.edu.certus.services.business.model.OperatorModel;
import pe.edu.certus.services.repository.entity.OperatorEntity;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class OperatorMapper {

    static OperatorEntity toEntity (OperatorModel operatorModel){
        OperatorEntity operatorEntity = new OperatorEntity();
        operatorEntity.setId(operatorModel.getId());
        operatorEntity.setName(operatorModel.getName());
        operatorEntity.setCellphone(operatorModel.getCellphone());
        operatorEntity.setEmail(operatorModel.getEmail());
        operatorEntity.setStatus(operatorModel.getStatus());
        operatorEntity.setTimestamp(operatorModel.getTimestamp() != null ?
                operatorModel.getTimestamp() :
                new Timestamp(System.currentTimeMillis()));

        return operatorEntity;
    }

    static OperatorModel toModelEntity(OperatorEntity operatorEntity){
        return new OperatorModel(
                operatorEntity.getId(),
                operatorEntity.getName(),
                operatorEntity.getCellphone(),
                operatorEntity.getEmail(),
                operatorEntity.getStatus(),
                operatorEntity.getTimestamp()
        );
    }

    static List<OperatorModel> toModelEntities(List<OperatorEntity> operatorEntities){
        return operatorEntities.stream()
                .map((OperatorMapper::toModelEntity))
                .collect(Collectors.toList());
    }
}
