package vermolae.model.dto.User;

import lombok.Builder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Builder
public class UserRegistrationForm implements Serializable {

    @NotBlank(message = "Set First name")
    @Pattern(regexp = "[a-zA-Z]", message = "Latin letters are allowed")
    private String firstname;

    @NotBlank(message = "Set email")
    @Pattern(regexp = "^([A-Za-z0-9+_.-]+@(.+))?$",
            message = "Latin letters, digits, dashes, underscores and points are allowed")
    private String email;

    @NotBlank(message = "Confirm email")
    @Pattern(regexp = "^([A-Za-z0-9+_.-]+@(.+))?$",
            message = "Latin letters, digits, dashes, underscores and points are allowed")
    private String confirmEmail;

    @NotBlank(message = "Set password")
    private String password;

    @NotBlank(message = "Confirm password")
    private String confirmPassword;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public UserRegistrationForm() {
    }

    public UserRegistrationForm(@NotBlank(message = "Set First name") @Pattern(regexp = "[a-zA-Z]", message = "Latin letters are allowed") String firstname, @NotBlank(message = "Set email") @Pattern(regexp = "^([A-Za-z0-9+_.-]+@(.+))?$",
            message = "Latin letters, digits, dashes, underscores and points are allowed") String email, @NotBlank(message = "Confirm email") @Pattern(regexp = "^([A-Za-z0-9+_.-]+@(.+))?$",
            message = "Latin letters, digits, dashes, underscores and points are allowed") String confirmEmail, @NotBlank(message = "Set password") String password, @NotBlank(message = "Confirm password") String confirmPassword) {
        this.firstname = firstname;
        this.email = email;
        this.confirmEmail = confirmEmail;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "UserRegistrationForm{" +
                "firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", confirmEmail='" + confirmEmail + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
