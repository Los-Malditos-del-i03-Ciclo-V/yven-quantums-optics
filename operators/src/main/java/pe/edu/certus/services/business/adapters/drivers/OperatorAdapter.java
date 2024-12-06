package pe.edu.certus.services.business.adapters.drivers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.certus.services.business.model.OperatorModel;
import pe.edu.certus.services.business.ports.drivers.ForOperator;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/v1/operators")
public class OperatorAdapter {

    private final ForOperator forOperator;

    public OperatorAdapter(ForOperator forOperator) {
        this.forOperator = forOperator;
    }

    @PostMapping("/create")
    public ResponseEntity<OperatorWebModel> createOperator(@RequestBody OperatorWebModel operatorWebModel){
        try {
            if (operatorWebModel.name() == null ||
                    operatorWebModel.email() == null ||
                    operatorWebModel.cellphone() == null){
                return ResponseEntity.badRequest().build();
            }

            OperatorModel operator = OperatorWebModel.toDomainModel(operatorWebModel);
            operator.setStatus(operator.getStatus() != null ? operator.getStatus() : false);

            forOperator.createOperatorModel(operator);
            return ResponseEntity.ok(OperatorWebModel.fromDomainModel(operator));
        } catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/batch")
    public ResponseEntity<List<OperatorWebModel>> createOperators(@RequestBody List<OperatorWebModel> operatorWebModels){
        try {
            List<OperatorWebModel> createdOperators = new ArrayList<>();

            for (OperatorWebModel operatorWebModel : operatorWebModels){
                if (operatorWebModel.name() == null
                        || operatorWebModel.email() == null
                        || operatorWebModel.cellphone() == null){
                    continue;
                }

                OperatorModel operator = OperatorWebModel.toDomainModel(operatorWebModel);
                operator.setStatus(operator.getStatus() != null ? operator.getStatus() : false);

                forOperator.createOperatorModel(operator);
                createdOperators.add(OperatorWebModel.fromDomainModel(operator));
            }

            if (createdOperators.isEmpty()){
                return ResponseEntity.badRequest().build();
            }

            return ResponseEntity.ok(createdOperators);

        } catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/query")
    public List<OperatorWebModel> getAllOperators(){
        List<OperatorModel> operators = forOperator.findAllOperatorModel();

        return operators.stream()
                .map(OperatorWebModel::fromDomainModel)
                .toList();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<OperatorWebModel> getOperatorById(@PathVariable Long id){
        OperatorModel operator = (OperatorModel) forOperator.findOperatorModelById(id);

        if (operator == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(OperatorWebModel.fromDomainModel(operator));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OperatorWebModel> updateOperator(@PathVariable Long id, OperatorWebModel operatorWebModel){
        OperatorModel existingOperator = (OperatorModel) forOperator.findOperatorModelById(id);

        if (existingOperator == null){
            return ResponseEntity.notFound().build();
        }

        OperatorModel operatorToUpdate = OperatorWebModel.toDomainModel(operatorWebModel);

        operatorToUpdate.setId(id);

        OperatorModel updatedOperator = (OperatorModel) forOperator.updateOperatorModel(id);

        return ResponseEntity.ok(OperatorWebModel.fromDomainModel(updatedOperator));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOperatorById(@PathVariable Long id){
        OperatorModel operator = (OperatorModel) forOperator.findOperatorModelById(id);

        if (operator == null){
            return ResponseEntity.notFound().build();
        }

        forOperator.deleteOperatorModelById(id);

        return ResponseEntity.ok().build();
    }

    private static final String OPERATORS_PAGE = "operadores";
    @GetMapping
    public String showOperators(Model model) {
        List<OperatorModel> operators = forOperator.findAllOperatorModel();
        model.addAttribute("operators", operators);
        return OPERATORS_PAGE;
    }
}
