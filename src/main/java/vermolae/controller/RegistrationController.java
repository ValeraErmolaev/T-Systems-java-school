package vermolae.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vermolae.crud.service.api.UserService;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.validator.RegistrationValidator;
import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationValidator regValidator;

    private final UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserRegistrationForm());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") @Valid UserRegistrationForm userRegForm, BindingResult result, Model model) {
        regValidator.validate(userRegForm, result);
        if (result.hasErrors()) {
            return "registration";
        }
        userService.registerUser(userRegForm);
        model.addAttribute("user", new UserAccountForm(userRegForm));
        return "account";
    }
}

