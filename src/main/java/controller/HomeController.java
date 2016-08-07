package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.SessionAccessor;

@Controller
@RequestMapping("home")
public class HomeController {
    
    private static final String INDEX = "index";
    private static final String HOME_JSP = "home";
    
    @RequestMapping(INDEX)
    public String index(HttpServletRequest request) {
        SessionAccessor session = new SessionAccessor(request);
        session.setFightForm(null);
        return HOME_JSP;
    }
}
