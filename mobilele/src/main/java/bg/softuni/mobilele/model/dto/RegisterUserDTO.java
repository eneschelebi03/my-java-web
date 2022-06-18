package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.validation.FieldsMatch;
import bg.softuni.mobilele.model.validation.UniqueEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@FieldsMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords should match"
)
public class RegisterUserDTO {

    @NotEmpty
    @Size(min = 2, max = 20)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String lastName;

    @NotEmpty(message = "Email should be provided.")
    @Email(message = "Email should be valid.")
    @UniqueEmail(message = "Email should be unique.")
    private String email;

    @NotEmpty
    @Size(min = 5)
    private String password;

    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public RegisterUserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterUserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterUserDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
