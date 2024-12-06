package pe.edu.certus.services.business.adapters.drivers;

import pe.edu.certus.services.business.model.OperatorModel;

import java.sql.Timestamp;

public record OperatorWebModel(Long id,
                               String name,
                               String email,
                               String cellphone,
                               Boolean status,
                               Timestamp timestamp) {

    public static OperatorWebModel fromDomainModel(OperatorModel operatorModel){
        return new OperatorWebModel(
                operatorModel.getId(),
                operatorModel.getName(),
                operatorModel.getEmail(),
                operatorModel.getCellphone(),
                operatorModel.getStatus(),
                operatorModel.getTimestamp()
        );
    }

    public static OperatorModel toDomainModel(OperatorWebModel operatorWebModel){
        return new OperatorModel(
                operatorWebModel.id(),
                operatorWebModel.name(),
                operatorWebModel.email(),
                operatorWebModel.cellphone(),
                operatorWebModel.status(),
                operatorWebModel.timestamp() != null ?
                        operatorWebModel.timestamp() :
                        new Timestamp(System.currentTimeMillis())
        );
    }
}