package form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import constant.SystemConstant;

public class LoginForm {

    @NotEmpty(message = "Username must not empty")
    @Size(max = 12, message = "Username can only 12 chars")
    private String username;
    @NotEmpty(message = "Password must not empty")
    private String password;
    private boolean validUsername;

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

    @AssertTrue(message = "Username can only alphabets and digits")
    public boolean isValidUsername() {
        return this.username != null && this.username.matches(SystemConstant.REGEX_VALID_USERNAME);
    }

}
