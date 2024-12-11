package pe.edu.certus.services.business.adapters.drivers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.certus.services.business.mapper.NotificationWebMapper;
import pe.edu.certus.services.business.mapper.NotificationWebModel;
import pe.edu.certus.services.business.model.NotificationModel;
import pe.edu.certus.services.business.ports.drivers.ForNotification;

import java.util.List;

@Controller
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationAdapter {
    private final ForNotification forNotification;

    @GetMapping
    public String listNotifications(Model model) {
        // TODO: Implement notification listing logic
        return "notifications";
    }

    @GetMapping("/crear")
    public String showCreateNotificationPage(Model model) {
        model.addAttribute("notification", NotificationWebModel.builder().build());
        return "crear-notification";
    }

    @PostMapping("/crear")
    public String createNotification(NotificationWebModel webModel) {
        NotificationModel notification = NotificationWebMapper.toModel(webModel);
        forNotification.processNotification(notification);
        return "redirect:/notifications";
    }
}
