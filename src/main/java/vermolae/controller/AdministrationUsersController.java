package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vermolae.crud.service.api.UserService;
import vermolae.model.dto.User.UserSearch;
import vermolae.model.entity.User;

import java.util.ArrayList;

@Controller

public class AdministrationUsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/administration/users",method = RequestMethod.GET)
    String getUserList(Model model){
        UserSearch emailOrContract = new UserSearch();
        model.addAttribute("emailOrContract",emailOrContract);
//        model.addAttribute("users",userService.getAll());
        return "administrationUsers";
    }
    @RequestMapping(value = "/administration/users",method = RequestMethod.POST)
    String getUserListByСondition(@ModelAttribute("emailOrContract") UserSearch emailOrContract, Model model){
        String cond = emailOrContract.getEmail();
        System.out.println(emailOrContract);
        System.out.println(cond);
        if (cond == ""){
            model.addAttribute("users",userService.getAll());
        }else {
            ArrayList<User> users = new ArrayList<>();
            try {
                users.add(userService.userByLogin(cond));
            }catch (Exception e){
                model.addAttribute("users", users);
            }
            model.addAttribute("users", users);
        }

        return "administrationUsers";
    }
    @RequestMapping(value = "/test/{id}/edit",method = RequestMethod.GET)
    String editUser(Model model){
        UserSearch emailOrContract = new UserSearch();
        model.addAttribute("emailOrContract",emailOrContract);
        model.addAttribute("users",userService.getAll());
        return "admin/edit";
    }


}
