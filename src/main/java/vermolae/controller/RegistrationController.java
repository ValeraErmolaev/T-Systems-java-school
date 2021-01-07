package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vermolae.crud.service.api.UserService;
import vermolae.model.entity.User;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "loginRegistration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
//        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
//            model.addAttribute("passwordError", "Пароли не совпадают");
//            return "registration";
//        }
        User user = userForm;
        if (userService.getUserByEMAil(user.getEmail()) != null) {

        }
        System.out.println(user.toString());
//        try { //TODO add try and exeptions
//            userService.createEntity(userForm);
        //
//            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "loginRegistration";
        }


    }

