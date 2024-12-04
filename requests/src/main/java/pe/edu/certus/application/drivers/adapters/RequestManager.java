package pe.edu.certus.application.drivers.adapters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pe.edu.certus.application.drivens.port.ForManagingRequest;
import pe.edu.certus.application.drivers.port.ForRequest;
import pe.edu.certus.domain.model.RequestPOJO;

import java.util.List;

@Service
public class RequestManager implements ForRequest<RequestPOJO, Long> {

    private static final Logger logger = LoggerFactory.getLogger(RequestManager.class);
    private final ForManagingRequest forManagingRequest;

    public RequestManager(ForManagingRequest forManagingRequest) {
        this.forManagingRequest = forManagingRequest;
    }

    @Override
    public void createRequestModel(RequestPOJO requestPOJO) {
        try {
            if (requestPOJO == null) {
                throw new IllegalArgumentException("Request model cannot be null");
            }
            logger.info("Creating new request model");
            forManagingRequest.saveRequest(requestPOJO);
            logger.info("Request model created successfully");
        } catch (Exception e) {
            logger.error("Error creating request model: {}", e.getMessage());
            throw new RuntimeException("Failed to create request model", e);
        }
    }

    @Override
    public RequestPOJO findRequestModelById(Long id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("ID cannot be null");
            }
            logger.info("Finding request model with ID: {}", id);
            RequestPOJO request = forManagingRequest.getRequestById(id);
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
    public List<RequestPOJO> findAllRequestModel() {
        try {
            logger.info("Retrieving all request models");
            List<RequestPOJO> requests = forManagingRequest.getAllRequests();
            logger.info("Found {} request models", requests.size());
            return requests;
        } catch (Exception e) {
            logger.error("Error retrieving all request models: {}", e.getMessage());
            throw new RuntimeException("Failed to retrieve request models", e);
        }
    }

    @Override
    public RequestPOJO updateRequestModel(RequestPOJO requestPOJO) {
        try {
            if (requestPOJO == null) {
                throw new IllegalArgumentException("Request model cannot be null");
            }
            logger.info("Updating request model with ID: {}", requestPOJO.getId());
            RequestPOJO updated = forManagingRequest.updateRequest(requestPOJO);
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
