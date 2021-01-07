package vermolae.model.dto.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

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
}
