package tr.com.ifikirli.sbrestapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerRegisterRequest {

    @NotNull(message = "Email must not be empty")
    @Size(max = 255, min = 3, message = "Email length must be between 3 and 255.")
    @Pattern(regexp = "^(.+)@(.+)$", message = "Invalid email address")
    private String email;

    @NotNull(message = "Name must not be empty")
    @Size(max = 255, min = 1, message = "Name length must be between 1 and 255.")
    private String name;

    @NotNull(message = "Surname must not be empty")
    @Size(max = 255, min = 1, message = "Surname length must be between 1 and 255.")
    private String surname;

    @NotNull(message = "Password must not be empty")
    @Size(max = 16, min = 8, message = "Password length must be between 8 and 16.")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
