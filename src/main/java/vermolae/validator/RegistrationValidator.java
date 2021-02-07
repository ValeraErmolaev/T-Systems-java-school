package vermolae.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vermolae.crud.service.api.UserService;
import vermolae.exeptions.UserNotFoundException;
import vermolae.model.dto.User.UserRegistrationForm;

@Component
@RequiredArgsConstructor
public class RegistrationValidator implements Validator {

    private final UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegistrationForm.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) throws UserNotFoundException {
        UserRegistrationForm userRegForm = (UserRegistrationForm) target;
        if (userRegForm.getFirstname().equals("")){
            errors.rejectValue("firstname","","The field should not be empty");
        }
        if (userRegForm.getLastname().equals("")){
            errors.rejectValue("lastname","","The field should not be empty");
        }
        if (userRegForm.getEmail().equals("")){
            errors.rejectValue("email","","The field should not be empty");
        }
        if (userRegForm.getPassport().equals("")){
            errors.rejectValue("passport","","The field should not be empty");
        }
        if (userRegForm.getPassword().equals("")){
            errors.rejectValue("password","","The field should not be empty");
        }
        if (userService.usersByEmail(userRegForm.getEmail()).size() != 0){
            errors.rejectValue("email","","This email is already in use");
        }
        if (!userRegForm.getEmail().equals(userRegForm.getConfirmEmail())){
            errors.rejectValue("confirmEmail","","Emails don't match");
        }
        if (userRegForm.getDate() == null){
            errors.rejectValue("date","","Please write your date of birth");
        }


    }
}
