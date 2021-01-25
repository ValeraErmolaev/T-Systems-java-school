package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vermolae.crud.service.api.UserService;
import vermolae.model.Enum.Role;
import vermolae.model.Enum.Status;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.entity.User;
import vermolae.security.UserDetailsServiceImpl;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/auth/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/auth/success")
    public ModelAndView getSuccessPage() {
        ModelAndView modelAndView = new ModelAndView();
        User user = userDetailsService.getCurrentUser();
        UserAccountForm userAccForm = new UserAccountForm(user);
        modelAndView.addObject("user", userAccForm);
        if (user.getStatus() == Status.BANNED){
            modelAndView.setViewName("login");
            modelAndView.addObject("message","This account is banned.");
            return modelAndView;
        }
        if (user.getRole().name().equals(Role.ADMIN.name())) {
            modelAndView.setViewName("administration/admin");
        } else {
            modelAndView.setViewName("account");
        }
        return modelAndView;
    }
}
