package pe.edu.certus.services.business.adapter.drivers;

import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.certus.services.business.domain.RequestModel;
import pe.edu.certus.services.business.ports.drivers.ForRequest;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/requests")
public class RequestAdapter {

    private final ForRequest forRequest;

    public RequestAdapter(ForRequest forRequest) {
        this.forRequest = forRequest;
    }

    @PostMapping("/create")
    public ResponseEntity<RequestWebModel> createRequest(@RequestBody RequestWebModel requestWebModel) {
        try {
            if (requestWebModel.category() == null || requestWebModel.description() == null) {
                return ResponseEntity.badRequest().build();
            }
            
            RequestModel request = RequestWebModel.toDomainModel(requestWebModel);
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
                
                RequestModel request = RequestWebModel.toDomainModel(requestWebModel);
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
        List<RequestModel> requests = forRequest.findAllRequestModel();
        return requests.stream()
                .map(RequestWebModel::fromDomainModel)
                .toList();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<RequestWebModel> getRequestById(@PathVariable Long id) {
        RequestModel request = (RequestModel) forRequest.findRequestModelById(id);
        if (request == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(RequestWebModel.fromDomainModel(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRequestBy(@PathVariable Long id) {
        RequestModel request = (RequestModel) forRequest.findRequestModelById(id);
        if (request == null) {
            return ResponseEntity.notFound().build();
        }
        forRequest.deleteRequestModelById(id);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<RequestWebModel> updateRequest(@PathVariable Long id, @RequestBody RequestWebModel requestWebModel) {
        RequestModel existingRequest = (RequestModel) forRequest.findRequestModelById(id);
        if (existingRequest == null) {
            return ResponseEntity.notFound().build();
        }

        RequestModel requestToUpdate = RequestWebModel.toDomainModel(requestWebModel);

        requestToUpdate.setId(id);

        RequestModel updatedRequest = (RequestModel) forRequest.updateRequestModel(requestToUpdate);

        return ResponseEntity.ok(RequestWebModel.fromDomainModel(updatedRequest));
    }
}
