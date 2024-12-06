package pe.edu.certus.services.business.adapter.drivens;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pe.edu.certus.services.business.domain.RequestModel;
import pe.edu.certus.services.business.ports.drivens.ForManagingRequest;
import pe.edu.certus.services.business.ports.drivers.ForRequest;

import java.util.List;

@Service
public class RequestManager implements ForRequest<RequestModel, Long> {

    private static final Logger logger = LoggerFactory.getLogger(RequestManager.class);
    private final ForManagingRequest forManagingRequest;

    public RequestManager(ForManagingRequest forManagingRequest) {
        this.forManagingRequest = forManagingRequest;
    }

    @Override
    public void createRequestModel(RequestModel requestModel) {
        try {
            if (requestModel == null) {
                throw new IllegalArgumentException("Request model cannot be null");
            }
            logger.info("Creating new request model");
            forManagingRequest.saveRequest(requestModel);
            logger.info("Request model created successfully");
        } catch (Exception e) {
            logger.error("Error creating request model: {}", e.getMessage());
            throw new RuntimeException("Failed to create request model", e);
        }
    }

    @Override
    public RequestModel findRequestModelById(Long id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("ID cannot be null");
            }
            logger.info("Finding request model with ID: {}", id);
            RequestModel request = forManagingRequest.getRequestById(id);
            if (request == null) {
                logger.warn("No request model found with ID: {}", id);
                throw new RuntimeException("Request not found");
            }
            return request;
        } catch (Exception e) {
            logger.error("Error finding request model: {}", e.getMessage());
            throw new RuntimeException("Failed to find request model", e);
        }
    }

    @Override
    public List<RequestModel> findAllRequestModel() {
        try {
            logger.info("Retrieving all request models");
            List<RequestModel> requests = forManagingRequest.getAllRequests();
            logger.info("Found {} request models", requests.size());
            return requests;
        } catch (Exception e) {
            logger.error("Error retrieving all request models: {}", e.getMessage());
            throw new RuntimeException("Failed to retrieve request models", e);
        }
    }

    @Override
    public RequestModel updateRequestModel(RequestModel requestModel) {
        try {
            if (requestModel == null) {
                throw new IllegalArgumentException("Request model cannot be null");
            }
            logger.info("Updating request model with ID: {}", requestModel.getId());
            RequestModel updated = forManagingRequest.updateRequest(requestModel);
            logger.info("Request model updated successfully");
            return updated;
        } catch (Exception e) {
            logger.error("Error updating request model: {}", e.getMessage());
            throw new RuntimeException("Failed to update request model", e);
        }
    }

    @Override
    public void deleteRequestModelById(Long id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("ID cannot be null");
            }
            logger.info("Deleting request model with ID: {}", id);
            forManagingRequest.deleteRequestById(id);
            logger.info("Request model deleted successfully");
        } catch (Exception e) {
            logger.error("Error deleting request model: {}", e.getMessage());
            throw new RuntimeException("Failed to delete request model", e);
        }
    }
}
