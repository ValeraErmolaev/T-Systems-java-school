package vermolae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {
    @RequestMapping(value = "/registration")
    String regNewUser(){
        return "registration";
    }
    @RequestMapping(value = "/registration/account")
    String regNewUserProcess(HttpServletRequest req, Model model,
                             @RequestParam(value = "firstname") String firstname,
                             @RequestParam(value = "lastame") String lastname,
                             @RequestParam(value = "patronymic") String patronymic,
                             @RequestParam(value = "birthday") String birthdayDate,
                             @RequestParam(value = "passport") String passport,
                             @RequestParam(value = "adress") String adress,
                             @RequestParam(value = "email") String eMail,
                             @RequestParam(value = "number") String number){

        return "account";
    }

}
