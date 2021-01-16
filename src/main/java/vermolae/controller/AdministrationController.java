package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vermolae.crud.service.api.UserService;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.model.dto.User.UserSearch;
import vermolae.model.entity.User;
import vermolae.security.UserDetailsServiceImpl;

import java.util.ArrayList;

@Controller

public class AdministrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @RequestMapping(value = "/administration/registration", method = RequestMethod.GET)
    String getAdminPage(Model model) {
        UserRegistrationForm userRegForm = new UserRegistrationForm();
        model.addAttribute("user", userRegForm);
        return "administration/registration";
    }

    @RequestMapping(value = "/administration/users", method = RequestMethod.GET)
    String getUserList(Model model) {
        UserSearch emailOrContractDTO = new UserSearch();
        model.addAttribute("emailOrContract", emailOrContractDTO);
        return "administration/users";
    }

    @RequestMapping(value = "/administration/users", method = RequestMethod.POST)
    String getUserListByСondition(@ModelAttribute("emailOrContract") UserSearch userSearchDTO, Model model) {
        String cond = userSearchDTO.getCondition();
        ArrayList<UserAccountForm> users = userService.userAccListByCond(cond);
        model.addAttribute("users", users);
        return "administration/users";
    }

    @RequestMapping(value = "/test/{id}/edit", method = RequestMethod.GET)
    String editUser(Model model) {
        UserSearch emailOrContract = new UserSearch();
        model.addAttribute("emailOrContract", emailOrContract);
        model.addAttribute("users", userService.getAll());
        return "admin/edit";
    }


}
