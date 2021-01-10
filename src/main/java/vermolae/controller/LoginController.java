package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import vermolae.crud.service.api.UserService;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.entity.User;
import vermolae.security.UserDetailsServiceImpl;

import java.security.Principal;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/auth/login")
    public String getLoginPage() {
//        model.addAttribute("user", new User());
        System.out.println("!!!!!!!! ");
        return "login";
    }

    @GetMapping("/auth/success")
    public ModelAndView getSuccessPage() {
        ModelAndView modelAndView = new ModelAndView();
        User user = userDetailsService.getCurrentUser();
        UserAccountForm userAccForm = new UserAccountForm(user);
//        model.addAttribute("userForm", new User());
        modelAndView.addObject("user", userAccForm);
        modelAndView.setViewName("account");
        return modelAndView;
    }
}
