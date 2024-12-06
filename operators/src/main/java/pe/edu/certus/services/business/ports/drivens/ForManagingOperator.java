package pe.edu.certus.services.business.ports.drivens;

import pe.edu.certus.services.business.model.OperatorModel;

import java.util.List;

public interface ForManagingOperator {

    void saveOperator(OperatorModel operatorModel);
    List<OperatorModel> getAllOperators();
    OperatorModel getOperatorById(Long id);
    OperatorModel updateOperator(OperatorModel operatorModel);
    void deleteOperatorById(Long id);

}
