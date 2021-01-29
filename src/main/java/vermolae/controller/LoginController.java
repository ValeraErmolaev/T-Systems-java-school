package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vermolae.crud.service.api.UserService;
import vermolae.model.Enum.Role;
import vermolae.model.Enum.Status;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.dto.User.UserLoginForm;
import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.model.entity.User;
import vermolae.security.UserDetailsServiceImpl;
import vermolae.validator.LoginValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private LoginValidator loginValidator;
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
