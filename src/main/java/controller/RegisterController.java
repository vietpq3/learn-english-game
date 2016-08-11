package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import logic.ILoginLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import param.LoginParam;
import form.LoginForm;

@Controller
@RequestMapping(value = "register")
public class RegisterController {

    private static final String REGISTER_JSP = "register";
    private static final String INDEX = "index";

    @Autowired
    private ILoginLogic loginLogic;

    @RequestMapping(value = { INDEX, "/" })
    public String index() {
        return REGISTER_JSP;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("form") LoginForm form, BindingResult binding,
            HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (binding.hasErrors()) {
            return REGISTER_JSP;
        }

        LoginParam param = new LoginParam();
        param.setUsername(form.getUsername());
        param.setPassword(form.getPassword());

        int result = 0;
        try {
            result = loginLogic.registerAccount(param);
        } catch (SQLException e) {
            binding.addError(new ObjectError("registerFail", "Username is in use"));
        }

        if (result == 1) {
            request.getRequestDispatcher("/login").forward(request, response);
        }

        return REGISTER_JSP;
    }

    @ModelAttribute("form")
    public LoginForm getForm() {
        return new LoginForm();
    }
}
