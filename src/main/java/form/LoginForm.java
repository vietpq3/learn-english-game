package form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import annotation.MessageConfig;
import constant.MessageConstant;
import constant.SystemConstant;

public class LoginForm extends AbstractForm {

    @NotEmpty(message = MessageConstant.MUST_NOT_EMPTY)
    @Size(max = 12, message = "{0} can only 12 chars")
    @Pattern(regexp = SystemConstant.REGEX_VALID_USERNAME, message = "{0} sai regex")
    @MessageConfig(order = 0, value = { "Username" })
    private String username;

    @NotEmpty(message = MessageConstant.MUST_NOT_EMPTY)
    @MessageConfig(order = 1, value = { "Password" })
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
