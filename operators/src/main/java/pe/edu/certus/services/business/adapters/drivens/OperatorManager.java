package pe.edu.certus.services.business.adapters.drivens;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pe.edu.certus.services.business.model.OperatorModel;
import pe.edu.certus.services.business.ports.drivens.ForManagingOperator;
import pe.edu.certus.services.business.ports.drivers.ForOperator;

import java.util.List;

@Service
public class OperatorManager implements ForOperator<OperatorModel, Long> {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(OperatorManager.class);
    private final ForManagingOperator forManagingOperator;

    public OperatorManager(ForManagingOperator forManagingOperator) {
        this.forManagingOperator = forManagingOperator;
    }

    @Override
    public void createOperatorModel(OperatorModel operatorModel) {
        try{
            if (operatorModel == null){
                throw new IllegalArgumentException("Operator model cannot be null");
            }
            logger.info("Creating new operator model");
            forManagingOperator.saveOperator(operatorModel);
            logger.info("Operator model created successfully");
        } catch (Exception e){
            logger.error("Error creating operator model: {}", e.getMessage());
            throw new RuntimeException("Failed to create operator model", e);
        }
    }

    @Override
    public OperatorModel findOperatorModelById(Long id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("ID cannot be null");
            }
            logger.info("Finding operator model with ID: {}", id);
            OperatorModel operator = forManagingOperator.getOperatorById(id);
            if (operator == null) {
                logger.warn("No operator model found with ID: {}", id);
                throw new RuntimeException("Operator not found");
            }
            return operator;
        } catch (Exception e){
            logger.error("Error finding operator model: {}", e.getMessage());
            throw new RuntimeException("Failed to find operator model", e);
        }
    }

    @Override
    public List<OperatorModel> findAllOperatorModel() {
        try{
            logger.info("Finding all operator models");
            List<OperatorModel> operators = forManagingOperator.getAllOperators();
            logger.info("Found {} operator models", operators.size());
            return operators;
        } catch (Exception e){
            logger.error("Error retrieving all operator models: {}", e.getMessage());
            throw new RuntimeException("Failed to retrieve operator models", e);
        }
    }

    @Override
    public OperatorModel updateOperatorModel(OperatorModel operatorModel) {
        try{
            if (operatorModel == null){
                throw new IllegalArgumentException("Operator model cannot be null");
            }
            logger.info("Updating operator model with ID: {}", operatorModel.getId());
            OperatorModel updatedOperator = forManagingOperator.updateOperator(operatorModel);
            logger.info("Operator model updated successfully");
            return updatedOperator;
        } catch (Exception e){
            logger.error("Error updating operator model: {}", e.getMessage());
            throw new RuntimeException("Failed to update operator model", e);
        }
    }

    @Override
    public void deleteOperatorModelById(Long id) {
        try{
            if (id == null) {
                throw new IllegalArgumentException("ID cannot be null");
            }
            logger.info("Deleting operator model with ID: {}", id);
            forManagingOperator.deleteOperatorById(id);
            logger.info("Operator model deleted successfully");
        } catch (Exception e) {
            logger.error("Error deleting operator model: {}", e.getMessage());
            throw new RuntimeException("Failed to delete operator model", e);
        }
    }
}
