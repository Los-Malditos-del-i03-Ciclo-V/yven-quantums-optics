//package pe.edu.certus.business.adapters.drivers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import pe.edu.certus.business.ports.drivers.ForPages;
//
//@Controller
//public class PagesAdapter implements ForPages {
//
//    private final String HOME_PAGE = "home";
//    private final String OPERATORS_PAGE = "operadores";
//    private final String REQUESTS_PAGE = "requests";
//    private final String REPORTS_PAGE = "reports";
//    private final String HELP_PAGE = "help";
//    private final String SETTINGS_PAGE = "settings";
//
//    @GetMapping("/home")
//    @Override
//    public String getHomePage() {
//        return "HOME_PAGE";
//    }
//
//    @GetMapping("/operators")
//    @Override
//    public String getOperatorsPage() {
//        return "OPERATORS_PAGE";
//    }
//
//    @GetMapping("/requests")
//    @Override
//    public String getRequestsPage() {
//        return "REQUESTS_PAGE";
//    }
//
//    @GetMapping("/reports")
//    @Override
//    public String getReportsPage() {
//        return "REPORTS_PAGE";
//    }
//
//    @GetMapping("/help")
//    @Override
//    public String getHelpPage() {
//        return "HELP_PAGE";
//    }
//
//    @GetMapping("/settings")
//    @Override
//    public String getSettingsPage() {
//        return "SETTINGS_PAGE";
//    }
//}
