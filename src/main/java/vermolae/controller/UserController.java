package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import vermolae.crud.dao.api.RoleDAO;
import vermolae.crud.service.api.UserService;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.entity.User;
import vermolae.security.SecurityUser;
import vermolae.security.UserDetailsServiceImpl;

import java.security.Principal;


@Controller
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    RoleDAO roleDAO;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping(value = "/Users")
    public String getUsers(ModelMap model) {

        model.addAttribute("user", userService.getEntityById(1));
//        System.out.println(userService.getEntityById(1));
        model.addAttribute("users", userService.getAll());
        return "allUsers";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String showRegisterPost(WebRequest request, Model model) {
        User user = userDetailsService.getCurrentUser();
        UserAccountForm userAccForm = new UserAccountForm(user);
//        model.addAttribute("userForm", new User());
        model.addAttribute("user", userAccForm);
        return "account";
    }
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String showAccountGet(WebRequest request, Model model) {
        User user = userDetailsService.getCurrentUser();
        UserAccountForm userAccForm = new UserAccountForm(user);
//        model.addAttribute("userForm", new User());
        model.addAttribute("user", userAccForm);
//        model.addAttribute("userForm", new User());
        return "account";
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
        user.setPassword(passwordEncoder.encode("12345"));
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
