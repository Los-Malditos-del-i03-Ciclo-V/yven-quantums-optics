package pe.edu.certus.services.business.ports.drivers;

import java.util.List;

public interface ForOperator<OperatorModel, Long> {

    void createOperatorModel(OperatorModel model);
    OperatorModel findOperatorModelById(Long id);
    List<OperatorModel> findAllOperatorModel();
    OperatorModel updateOperatorModel(OperatorModel model);
    void deleteOperatorModelById(Long id);

}
