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

//    @ModelAttribute("user")
//    public UserRegistrationForm userDto() {
//        return UserRegistrationForm.builder().build();
//    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserRegistrationForm());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") UserRegistrationForm userDto, BindingResult result, Model model) {
        User userValidate = null;
        if (result.hasErrors()) {
            return "registration";
        }
        try {
           userValidate = userService.getUserByEMAil(userDto.getEmail());
        } catch (Exception e) {
            if (userValidate != null) {
                model.addAttribute("emailIsNotUniqueError", "A user with this Email already exists");
                return "registration";
            }
        }
       //TODO INPUT MUST BE NOT NULL

        if (!userDto.getEmail().equals(userDto.getConfirmEmail())) {
            model.addAttribute("emailsMatchError", "Emails don't match");
            return "registration";
        }

        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            model.addAttribute("passwordError", "Passwords don't match");
            return "registration";
        }

        userService.registerUser(userDto);

        //  try { //TODO add try and exeptions

        model.addAttribute("user",userDto);

        return "account";
    }


}

