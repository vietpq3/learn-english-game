package controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.LoginDao;
import entity.UserInfo;
import form.LoginForm;

@Controller
@RequestMapping(value = { "/" })
public class Login {
    
    @RequestMapping(value = { "/", "" })
    public String index() {
        return "login";
    }
    
    @RequestMapping("login")
    public String login(@ModelAttribute("form") LoginForm form,
            BindingResult binding) throws SQLException {
        String username = form.getUsername();
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "module.xml");
        LoginDao loginDao = (LoginDao) context.getBean("loginDao");
        List<UserInfo> userInfoList = loginDao.checkLogin(username);
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo.getUsername());
        }
        return "login";
    }
    
    @ModelAttribute("form")
    public LoginForm getForm() {
        return new LoginForm();
    }
}
