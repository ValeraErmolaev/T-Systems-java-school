package vermolae.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import vermolae.crud.service.api.ContractService;
import vermolae.crud.service.api.OptionService;
import vermolae.crud.service.api.TariffService;
import vermolae.crud.service.api.UserService;
import vermolae.model.Cart.Cart;
import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.entity.Contract;
import vermolae.model.entity.Option;
import vermolae.model.entity.Tariff;
import vermolae.model.entity.User;
import vermolae.security.UserDetailsServiceImpl;

import java.util.List;


@Controller
@RequiredArgsConstructor
@SessionAttributes("userCart")
public class UserController {

    private final UserService userService;

    private final OptionService optionService;

    private final TariffService tariffService;

    private final ContractService contractService;

    private final UserDetailsServiceImpl userDetailsService;

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
    public String blockControllerById(@PathVariable int id, @PathVariable int user_id) {
        userService.blockContract(user_id, id);
        return "redirect:/auth/success";
    }

    @RequestMapping(value = "/user/{user_id}/contract/{id}/unblock", method = RequestMethod.POST)
    public String unBlockControllerById(@PathVariable int id, @PathVariable int user_id) {
        userService.unBlockContract(user_id, id);
        return "redirect:/auth/success";
    }

    @RequestMapping(value = "/user/editor/{contract_id}/addOption", method = RequestMethod.GET)
    public String listAvailableOptions(@PathVariable int contract_id, Model model) {
        User curUser = userDetailsService.getCurrentUser();
        UserAccountForm user = new UserAccountForm(curUser);
        List<Option> options = optionService.listOfAvailableOptions(curUser.getId(), contract_id);
        List<Contract> contracts = contractService.contractsById(contract_id);
        model.addAttribute("contracts", contracts);
        model.addAttribute("options", options);
        model.addAttribute("user", user);
        return "/user/editor/listOptionsToContract";
    }

    @RequestMapping(value = "/user/editor/{contract_id}/addOption/{option_id}", method = RequestMethod.POST)
    public String addNewOptionToContract(@PathVariable int contract_id, @PathVariable int option_id) {
        contractService.addNewOption(contract_id, option_id);
        return "redirect:/user/editor/{contract_id}/addOption";
    }

    @RequestMapping(value = "/user/editor/{contract_id}/deleteOption/{option_id}", method = RequestMethod.POST)
    public String deleteOptionFromContract(@PathVariable int contract_id, @PathVariable int option_id) {
        contractService.deleteOption(contract_id, option_id);
        return "redirect:/user/editor/{contract_id}/addOption";
    }
    @RequestMapping(value = "/user/editor/{contract_id}/listTariffsToContract", method = RequestMethod.GET)
    public String listTariffsToChangeUser(@PathVariable int contract_id, Model model) {
        List<Tariff> tariffs = tariffService.getAll();
        List<TariffViewForm> tariffsDTO = tariffService.getTariffViewList(tariffs);
        List<Contract> contracts = contractService.contractsById(contract_id);
        User curUser = userDetailsService.getCurrentUser();
        UserAccountForm user = new UserAccountForm(curUser);
        model.addAttribute("tariffs", tariffsDTO);
        model.addAttribute("contracts", contracts);
        model.addAttribute("user", user);
        return "/user/editor/listTariffsToContract";
    }
    @RequestMapping(value = "/user/editor/{contract_id}/changeTariff/{tariff_id}", method = RequestMethod.GET)
    public String setTariffToContractUser(@PathVariable int contract_id, @PathVariable int tariff_id) {
        contractService.setTariff(contract_id, tariff_id);
        return "redirect:/auth/success";

    }
    @RequestMapping(value = "/user/editor/{contract_id}/setTariffFromCart", method = RequestMethod.GET)
    public String setTariffFromCart(@PathVariable int contract_id, @ModelAttribute("userCart") Cart cart) {
//        contractService.setTariffAndOptionsFromCart(cart,contract_id);
        List<Contract> contracts = contractService.contractsById(contract_id);
        if (cart.getTariff() != null) {
            for (Contract contract : contracts) {
                contract.getTariff().getContracts().remove(contract);
                tariffService.updateEntity(contract.getTariff());
                for (Option option : contract.getOptions()) {
                    option.getContracts().remove(contract);
                    optionService.updateEntity(option);
                }
                contract.getOptions().clear();
                contract.setTariff(cart.getTariff());
                contract.setOptions(cart.getOptions());
                contractService.updateEntity(contract);
                cart.setTariff(null);
                cart.getOptions().clear();
            }
        }
        return "redirect:/auth/success";
    }

}
