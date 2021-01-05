package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vermolae.crud.service.serviceImpl.UserServiceImpl;
import vermolae.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/registration")
    String regNewUser(){
        return "registration";
    }
    @RequestMapping(value = "/registration/account")
    String regNewUserProcess(HttpServletRequest req, Model model,
                             @RequestParam(value = "firstname") String firstname,
                             @RequestParam(value = "lastname") String lastname,
                             @RequestParam(value = "patronymic") String patronymic,
                             @RequestParam(value = "birthday") String birthdayDate,
                             @RequestParam(value = "passport") String passport,
                             @RequestParam(value = "address") String address,
                             @RequestParam(value = "email") String eMail,
//                             @RequestParam(value = "contract") String contract,
                             @RequestParam(value = "password") String password){

//        User user = new User(firstname,lastname, patronymic, birthdayDate, passport,address, eMail,password);
//        userService.save(user);
//        System.out.println("success");
//        System.out.println(user.toString());
        List<User> users = userService.getAll();
//        for (User a_user:users){
//            System.out.println(a_user.getRole());
//        }
        model.addAttribute("users", users);
        return "allUsers";
    }
    @RequestMapping(value = "/reg")
    String regNewUserTest(){
        return "reg";
    }
}
