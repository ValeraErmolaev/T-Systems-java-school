package vermolae.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vermolae.crud.dao.api.PictureDAO;
import vermolae.model.entity.User;

//import vermolae.crud.service.serviceApi.RoleService;


@Controller
public class HomeController {

    @Autowired
    PictureDAO pictureDAO;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) throws Exception {
        User user = new User();
        model.addAttribute(user);

//        pictureDAO.loadNewPicture();

        return "home";
    }
    @RequestMapping(value = "/log_reg", method = RequestMethod.GET)
    public String log_reg() {


//        return "log_reg";
        return "login";
    }


}