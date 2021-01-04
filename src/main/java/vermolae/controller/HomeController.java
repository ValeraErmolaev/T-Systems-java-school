package vermolae.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.Query;

@Controller
public class HomeController {


    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/home_v2")
    public String home_v2() {
        return "home_v2";
    }
//    @RequestMapping(value = "/getAll")
//    public String allUsers(Model model){
////        userService
//        return "allUsers";
//    }

}