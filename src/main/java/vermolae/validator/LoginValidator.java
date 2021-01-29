package vermolae.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vermolae.crud.service.api.UserService;
import vermolae.model.Enum.Status;
import vermolae.model.dto.User.UserLoginForm;
import vermolae.model.entity.User;
import vermolae.security.UserDetailsServiceImpl;
@Component
public class LoginValidator implements Validator {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getStatus() == Status.BANNED){
            errors.rejectValue("message","","This account is banned.");
        }


    }
}
