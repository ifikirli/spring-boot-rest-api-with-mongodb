package tr.com.ifikirli.sbrestapi.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerRegisterModel {

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
}
