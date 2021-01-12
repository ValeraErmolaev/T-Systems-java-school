package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vermolae.crud.service.api.UserService;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.model.entity.User;
import vermolae.security.UserDetailsServiceImpl;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserRegistrationForm());

        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView addUser(@ModelAttribute("user") UserRegistrationForm userRegForm, Model model,HttpServletRequest request) {
        //TODO Controller must be 2-3 rows!
        ModelAndView modelAndView = new ModelAndView();
        User userValidate = null;
        try {
            userValidate = userService.getUserByEMAil(userRegForm.getEmail());
            if (userValidate != null) {
                modelAndView.setViewName("registration");
                modelAndView.addObject("emailIsNotUniqueError", "A user with this Email already exists");
                return modelAndView;
            }

        } catch (Exception e) {
//            if (userValidate != null) {
//                modelAndView.setViewName("registration");
//                modelAndView.addObject("emailIsNotUniqueError", "A user with this Email already exists");
//                return modelAndView;
//            }
        }
        //TODO INPUT MUST BE NOT NULL

        if (!userRegForm.getEmail().equals(userRegForm.getConfirmEmail())) {
            modelAndView.setViewName("registration");
            modelAndView.addObject("emailsMatchError", "Emails don't match");
            return modelAndView;
        }

        if (!userRegForm.getPassword().equals(userRegForm.getConfirmPassword())) {
            modelAndView.setViewName("registration");
            modelAndView.addObject("passwordError", "Passwords don't match");
            return modelAndView;
        }

        userService.registerUser(userRegForm);

        //  try { //TODO add try and exeptions

        UserAccountForm userAccForm = new UserAccountForm(userRegForm);
        modelAndView.addObject("user",userAccForm);
        modelAndView.setViewName("account");
        try {
            userDetailsService.authWithHttpServletRequest(request, userRegForm.getEmail(), userRegForm.getPassword());
        }catch (Exception e){
            //TODO LOGGER
            System.out.println("EXCEPTION");
        }
        return modelAndView;
    }


}

