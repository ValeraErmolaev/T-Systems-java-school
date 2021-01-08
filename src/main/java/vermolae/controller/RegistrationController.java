package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vermolae.crud.service.api.UserService;
import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.model.entity.User;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationForm userDto() {
        return UserRegistrationForm.builder().build();
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserRegistrationForm());

        return "loginRegistration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") UserRegistrationForm userDto, BindingResult result, Model model) {
        User userValidate = null;
        if (result.hasErrors()) {
            return "loginRegistration";
        }
        try {
           userValidate = userService.getUserByEMAil(userDto.getEmail());
        } catch (Exception e) {
            if (userValidate != null) {
                model.addAttribute("emailIsNotUniqueError", "A user with this Email already exists");
                return "loginRegistration";
            }
        }
        //TODO email is not unique!

        if (!userDto.getEmail().equals(userDto.getConfirmEmail())) {
            model.addAttribute("emailsMutchError", "Emails don't match");
            return "loginRegistration";
        }

        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            model.addAttribute("passwordError", "Passwords don't match");
            return "loginRegistration";
        }

        userService.registerUser(userDto); //TODO new method in services
//        if (userService.getUserByEMAil(user.getEmail()) != null) {

//        }
//        System.out.println(userDto.toString());
//        try { //TODO add try and exeptions
//
        //
//            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
        return "loginRegistration";
    }


}

