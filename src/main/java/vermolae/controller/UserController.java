package vermolae.controller;

import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import vermolae.crud.dao.api.RoleDAO;
import vermolae.crud.service.api.UserService;
import vermolae.entity.Role;
import vermolae.entity.User;


@Controller
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    RoleDAO roleDAO;

    @GetMapping(value = "/Users")
    public String getUsers(ModelMap model) {

        model.addAttribute("user", userService.getEntityById(1));
        System.out.println(userService.getEntityById(1));
        model.addAttribute("users", userService.getAll());
        return "allUsers";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String showRegister(WebRequest request, Model model) {

        model.addAttribute("user", new User());
        return "reg";
    }

    @RequestMapping(value = "/created", method = RequestMethod.POST)
    public String showCreated(WebRequest request, Model model) {
        System.out.println(request.getParameter("user"));

//        User user = new User();
////        user.setId(1);
//        user.setFirstname("Alena");
//        userService.createEntity(user);
        //new user
//        Role role = new Role().
        User user = new User();
        user.setFirstname("UserFromController");
        user.setEmail("user@email.com");
        user.setPasswordHash(passwordEncoder.encode("12345"));
        user.setRole(roleDAO.getRoleByName("User"));
        userService.createEntity(user);
        model.addAttribute(user);
        return "created";
    }
//    @RequestMapping(value = "/reg",method = RequestMethod.POST)
//    public ModelAndView addUser(HttpRequest request, HttpResponse response,
//                                @ModelAttribute("user") User user){
//        return new ModelAndView("created","firstname",user.getFirstname());
//    }

}
