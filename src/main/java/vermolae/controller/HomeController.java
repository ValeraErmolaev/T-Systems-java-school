package vermolae.controller;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import vermolae.crud.dao.api.PictureDAO;
import vermolae.model.entity.User;

//import vermolae.crud.service.serviceApi.RoleService;


@Controller
public class HomeController {

//    private final PictureDAO pictureDAO;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) throws Exception {
        User user = new User();
        model.addAttribute(user);
        return "home";
    }
//    @RequestMapping(value = "/log_reg", method = RequestMethod.GET)
//    public String log_reg() {
//        return "login";
//    }


}