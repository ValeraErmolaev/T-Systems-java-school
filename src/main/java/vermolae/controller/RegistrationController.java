package vermolae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
    @RequestMapping(value = "/registration")
    String regNewUser(){
        return "registration";
    }
    @RequestMapping(value = "/registration/account")
    String regNewUserProcess(Model model){
        
        return "account";
    }
}
