package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vermolae.crud.service.serviceImpl.UserService;
import vermolae.entity.User;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value="/Users")
    public String getUsers(ModelMap model) {
        final int recordsPerPage = 100;

//        long rows = userService.count();
//        int nOfPages = (int)(rows / recordsPerPage);

//        if (nOfPages % recordsPerPage > 0) {
//            nOfPages++;
//        }

//        if(currentPage == null)
//            currentPage = 1;

        List<User> users = userService.getAll();

        model.addAttribute("users", users);

//        model.addAttribute("noOfPages", nOfPages);
//        model.addAttribute("currentPage", currentPage);
//        model.addAttribute("recordsPerPage", recordsPerPage);

        return "allUsers";
    }
}
