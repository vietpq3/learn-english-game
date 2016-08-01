package controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import param.LoginParam;
import dao.ILoginDao;
import entity.UserInfo;
import form.LoginForm;

@Controller
@RequestMapping(value = { "/" })
public class LoginController {
    
    private static final String LOGIN_JSP = "login";
    private static final String REDIRECT_HOME = "redirect:home/index";
    
    @Autowired
    private ILoginDao loginDao;
    
    @RequestMapping(value = { "/", "", "index" })
    public String index() {
        return LOGIN_JSP;
    }
    
    @RequestMapping("login")
    public String login(@Valid @ModelAttribute("form") LoginForm form,
            BindingResult binding, Model model) throws SQLException {
        
        if (binding.hasErrors()) {
            return LOGIN_JSP;
        }
        
        LoginParam param = new LoginParam();
        param.setUsername(form.getUsername());
        param.setPassword(form.getPassword());
        
        List<UserInfo> userInfoList = loginDao.checkLogin(param);
        if (userInfoList != null && userInfoList.size() > 0) {
            return REDIRECT_HOME;
        } else {
            binding.addError(new ObjectError("loginFail",
                    "Username and password are not mapping"));
            return LOGIN_JSP;
        }
    }
    
    @ModelAttribute("form")
    public LoginForm getForm() {
        return new LoginForm();
    }
}
