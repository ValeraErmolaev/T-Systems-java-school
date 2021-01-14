package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vermolae.crud.service.api.UserService;
import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.model.dto.User.UserSearch;
import vermolae.model.entity.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller

public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String getUserList(Model model){
        UserSearch emailOrContract = new UserSearch();
        model.addAttribute("emailOrContract",emailOrContract);
        model.addAttribute("users",userService.getAll());
        return "test";
    }
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    String getUserListByСondition(@ModelAttribute("emailOrContract") UserSearch emailOrContract, Model model){
//        UserSearch emailOrContract = new UserSearch();
//        ModelAndView mav  = new ModelAndView();

        String cond = emailOrContract.getEmail();
        System.out.println(emailOrContract);
        System.out.println(cond);
        if (cond == ""){
            model.addAttribute("users",userService.getAll());
        }else {
            ArrayList<User> users = new ArrayList<>();
            try {
                users.add(userService.getUserByEMAil(cond));
            }catch (Exception e){
                model.addAttribute("users", users);
            }
            model.addAttribute("users", users);
        }

        return "test";
    }

}
