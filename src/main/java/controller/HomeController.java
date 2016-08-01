package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
    
    private static final String INDEX = "index";
    private static final String HOME_JSP = "home";

    @RequestMapping(INDEX)
    public String index() {
        return HOME_JSP;
    }
}
