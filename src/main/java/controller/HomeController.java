package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.SessionAccessor;

@Controller
@RequestMapping("home")
public class HomeController {

    private static final String INDEX = "index";
    private static final String HOME_JSP = "home";
    private static final String REDIRECT_LOGIN = "redirect:/";

    @RequestMapping(value = INDEX)
    public String index(HttpServletRequest request, Model model) {
        SessionAccessor session = new SessionAccessor(request);

        if (session.getLoginUser() == null) {
            return REDIRECT_LOGIN;
        }

        model.addAttribute("loginUser", session.getLoginUser().getUsername());
        model.addAttribute("highScore", session.getLoginUser().getHighScore());

        session.setFightForm(null);

        return HOME_JSP;
    }
}
