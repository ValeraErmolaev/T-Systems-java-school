package vermolae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.model.entity.User;

@Controller
public class LoginController {

    @GetMapping("/auth/login")
    public String getLoginPage() {
//        model.addAttribute("user", new User());
        System.out.println("!!!!!!!! ");
        return "login";
    }
    @GetMapping("/auth/success")
    public String getSuccessPage(){
        System.out.println("OLOLO");
        return "account";
    }
}
