package vermolae.model.dto.User;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Date;

@Builder
public class UserRegistrationForm implements Serializable {


    private String firstname;
    private String lastname;
    private Date date;
    private String passport;
    private String email;


    private String confirmEmail;


    private String password;


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

    public UserRegistrationForm(String firstname, String lastname, Date date, String passport, String email, String confirmEmail, String password, String confirmPassword) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = date;
        this.passport = passport;
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
