package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vermolae.crud.service.api.UserService;
import vermolae.crud.service.impl.UserServiceImpl;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.model.dto.User.UserSearch;
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

    @RequestMapping(value = "/administration/registration", method = RequestMethod.POST)
    String createUserByAdmin(@ModelAttribute("user") UserRegistrationForm userRegForm, Model model) {
        //TODO IF ALL IS OK THEN REGISTRY
        userService.registerUser(userRegForm);
        UserSearch emailOrContractDTO = new UserSearch();
        emailOrContractDTO.setCondition(userRegForm.getEmail());
        ArrayList<UserAccountForm> users = userService.userAccListByCond(userRegForm.getEmail());
        model.addAttribute("emailOrContract", emailOrContractDTO);
        model.addAttribute("users",users);
        return "redirect:/administration/users";
    }

  //  @RequestBody

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

    @RequestMapping(value = "/administration/editor/user/{id}", method = RequestMethod.GET)
    String editUser(Model model, @PathVariable int id) {
//        UserSearch emailOrContract = new UserSearch();
        UserAccountForm userAccForm = new UserAccountForm(userService.getEntityById(id));
//        model.addAttribute("emailOrContract", emailOrContract);
        model.addAttribute("user", userAccForm);
        return "/administration/editor/user";
    }
    @RequestMapping(value = "/administration/editor/user/{id}/addContract", method = RequestMethod.GET)
    String addNewContract(Model model, @PathVariable int id){
        userService.createAndAddNewContract(userService.getEntityById(id));
        return "redirect:/administration/editor/user/{id}";
    }


}
