package pe.edu.certus.services.business.adapter.drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pe.edu.certus.services.business.domain.RequestModel;
import pe.edu.certus.services.business.ports.drivers.ForRequest;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/home")
public class HomeAdapter {

    @Autowired
    ForRequest forRequest;

    @GetMapping
    public ModelAndView showHome() {
        List<RequestModel> ultimosViaticos = (List<RequestModel>) forRequest.findAllRequestModel().stream()
                .sorted(Comparator.comparing(RequestModel::getId).reversed())
                .limit(5)
                .collect(Collectors.toList());

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("ultimosViaticos", ultimosViaticos);
        return modelAndView;
    }
}
