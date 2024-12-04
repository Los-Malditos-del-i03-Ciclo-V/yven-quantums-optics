package pe.edu.certus.application.drivens.adapter;

import pe.edu.certus.domain.model.RequestPOJO;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class RequestManager {
    
    public RequestPOJO validateAndEnrichRequest(RequestPOJO requestPOJO) {
        if (requestPOJO == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        // Enrich with default values if needed
        if (requestPOJO.getStatus() == null) {
            requestPOJO.setStatus(false);
        }
        
        // Validate required fields
        if (requestPOJO.getCategory() == null || requestPOJO.getCategory().trim().isEmpty()) {
            throw new IllegalArgumentException("Category is required");
        }
        
        if (requestPOJO.getDescription() == null || requestPOJO.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Description is required");
        }
        
        return requestPOJO;
    }
    
    public List<RequestPOJO> enrichRequestList(List<RequestPOJO> requests) {
        if (requests == null) {
            return new ArrayList<>();
        }
        
        return requests.stream()
                .map(this::validateAndEnrichRequest)
                .toList();
    }
    
    public Optional<RequestPOJO> enrichSingleRequest(Optional<RequestPOJO> requestOpt) {
        return requestOpt.map(this::validateAndEnrichRequest);
    }
}
