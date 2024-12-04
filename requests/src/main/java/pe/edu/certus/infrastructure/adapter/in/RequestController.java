package pe.edu.certus.infrastructure.adapter.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.certus.application.drivers.port.ForRequest;
import pe.edu.certus.domain.model.RequestPOJO;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/requests")
public class RequestController {

    private final ForRequest forRequest;

    public RequestController(ForRequest forRequest) {
        this.forRequest = forRequest;
    }

    @PostMapping("/create")
    public ResponseEntity<RequestWebModel> createRequest(@RequestBody RequestWebModel requestWebModel) {
        try {
            if (requestWebModel.category() == null || requestWebModel.description() == null) {
                return ResponseEntity.badRequest().build();
            }
            
            RequestPOJO request = RequestWebModel.toDomainModel(requestWebModel);
            request.setStatus(request.getStatus() != null ? request.getStatus() : false);

            forRequest.createRequestModel(request);
            return ResponseEntity.ok(RequestWebModel.fromDomainModel(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/batch")
    public ResponseEntity<List<RequestWebModel>> createRequests(@RequestBody List<RequestWebModel> requestWebModels) {
        try {
            List<RequestWebModel> createdRequests = new ArrayList<>();
            
            for (RequestWebModel requestWebModel : requestWebModels) {
                if (requestWebModel.category() == null || requestWebModel.description() == null) {
                    continue;
                }
                
                RequestPOJO request = RequestWebModel.toDomainModel(requestWebModel);
                request.setStatus(request.getStatus() != null ? request.getStatus() : false);

                forRequest.createRequestModel(request);
                createdRequests.add(RequestWebModel.fromDomainModel(request));
            }
            
            if (createdRequests.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            
            return ResponseEntity.ok(createdRequests);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/query")
    public List<RequestWebModel> getAllRequests() {
        List<RequestPOJO> requests = forRequest.findAllRequestModel();
        return requests.stream()
                .map(RequestWebModel::fromDomainModel)
                .toList();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<RequestWebModel> getRequestById(@PathVariable Long id) {
        RequestPOJO request = (RequestPOJO) forRequest.findRequestModelById(id);
        if (request == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(RequestWebModel.fromDomainModel(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRequestBy(@PathVariable Long id) {
        RequestPOJO request = (RequestPOJO) forRequest.findRequestModelById(id);
        if (request == null) {
            return ResponseEntity.notFound().build();
        }
        forRequest.deleteRequestModelById(id);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<RequestWebModel> updateRequest(@PathVariable Long id, @RequestBody RequestWebModel requestWebModel) {
        RequestPOJO existingRequest = (RequestPOJO) forRequest.findRequestModelById(id);
        if (existingRequest == null) {
            return ResponseEntity.notFound().build();
        }
        
        RequestPOJO requestToUpdate = RequestWebModel.toDomainModel(requestWebModel);

        requestToUpdate.setId(id);
        
        RequestPOJO updatedRequest = (RequestPOJO) forRequest.updateRequestModel(requestToUpdate);

        return ResponseEntity.ok(RequestWebModel.fromDomainModel(updatedRequest));
    }
}
