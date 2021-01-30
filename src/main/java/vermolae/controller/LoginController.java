package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vermolae.crud.service.api.UserService;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.dto.User.UserLoginForm;
import vermolae.model.entity.User;
import vermolae.security.UserDetailsServiceImpl;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/auth/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new UserLoginForm());
        return "login";
    }

    @GetMapping("/auth/success")
    public String getSuccessPage(Model model) {
        User user = userDetailsService.getCurrentUser();
        model.addAttribute("user", new UserAccountForm(user));
        return userService.pageDependsOfRole(user);
    }
}
