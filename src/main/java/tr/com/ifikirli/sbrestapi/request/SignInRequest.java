package tr.com.ifikirli.sbrestapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SignInRequest {

    @NotNull(message = "Email must not be empty")
    @Size(max = 255, min = 3, message = "Email length must be between 3 and 255.")
    @Pattern(regexp = "^(.+)@(.+)$", message = "Invalid email address")
    private String email;

    @NotNull(message = "Password must not be empty")
    @Size(max = 16, min = 8, message = "Password length must be between 8 and 16.")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
