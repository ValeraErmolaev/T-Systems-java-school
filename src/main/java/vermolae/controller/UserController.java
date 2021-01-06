package vermolae.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import vermolae.crud.service.api.UserService;


@Controller
public class UserController {


    @Autowired
    private UserService userService;

//    @Autowired
//    UserDAO userDAO;

    @GetMapping(value = "/Users")
    public String getUsers(ModelMap model) {
//        model.addAttribute("users", userDao.allUsers());
        model.addAttribute("user",userService.getEntityById(1));
        System.out.println(userService.getEntityById(1));
        model.addAttribute("users", userService.getAll());

//        List<User> users = userRepositoryJPA.findAll();
//        List<User> users = userService.getAll();
//        model.addAttribute("users", users);
        return "allUsers";
    }
}
