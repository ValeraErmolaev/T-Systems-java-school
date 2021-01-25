package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import vermolae.crud.service.api.ContractService;
import vermolae.crud.service.api.UserService;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.entity.Contract;
import vermolae.model.entity.User;
import vermolae.security.UserDetailsServiceImpl;




@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping(value = "/Users")
    public String getUsers(ModelMap model) {
        model.addAttribute("users", userService.getAll());
        return "allUsers";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String showRegisterPost(WebRequest request, Model model) {
        User user = userDetailsService.getCurrentUser();
        UserAccountForm userAccForm = new UserAccountForm(user);
        model.addAttribute("user", userAccForm);
        return "account";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String showAccountGet(Model model) {
        User user = userDetailsService.getCurrentUser();
        UserAccountForm userAccForm = new UserAccountForm(user);
        model.addAttribute("user", userAccForm);
        return "account";
    }

    @RequestMapping(value = "/user/{user_id}/contract/{id}/block", method = RequestMethod.POST)
    public String blockControllerById(@PathVariable int id,@PathVariable int user_id) {
        User user = userService.getEntityById(user_id);
        Contract contract = contractService.getEntityById(id);
        if (user.getContracts().contains(contract)){
            contract.setIs_blocked(true);
            contractService.updateEntity(contract);
        }
        return "redirect:/auth/success";
    }
    @RequestMapping(value = "/user/{user_id}/contract/{id}/unblock", method = RequestMethod.POST)
    public String unBlockControllerById(@PathVariable int id,@PathVariable int user_id) {
        User user = userService.getEntityById(user_id);
        Contract contract = contractService.getEntityById(id);
        if (user.getContracts().contains(contract)){
            contract.setIs_blocked(false);
            contractService.updateEntity(contract);
        }
        return "redirect:/auth/success";
    }

}
