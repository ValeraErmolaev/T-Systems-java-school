package vermolae.controller;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vermolae.entity.User;

//import vermolae.crud.service.serviceApi.RoleService;


@Controller
public class HomeController {
//    @Autowired
//    RoleService roleService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        User user = new User();
        model.addAttribute(user);

        return "home";
    }
    @RequestMapping(value = "/log_reg", method = RequestMethod.GET)
    public String log_reg() {


//        return "log_reg";
        return "loginRegistration";
    }


}