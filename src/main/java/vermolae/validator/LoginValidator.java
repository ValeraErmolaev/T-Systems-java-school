package vermolae.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vermolae.model.Enum.Status;
import vermolae.model.entity.User;

@Component
public class LoginValidator implements Validator {

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
