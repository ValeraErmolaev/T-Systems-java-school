package vermolae.controller;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vermolae.crud.service.api.ContractService;
import vermolae.crud.service.api.OptionService;
import vermolae.crud.service.api.TariffService;
import vermolae.crud.service.api.UserService;
import vermolae.exeptions.OptionAssociateException;
import vermolae.model.Cart.Cart;
import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.model.dto.User.UserSearch;
import vermolae.model.entity.Contract;
import vermolae.model.entity.Option;
import vermolae.model.entity.Tariff;
import vermolae.model.entity.User;
import vermolae.security.UserDetailsServiceImpl;
import vermolae.validator.RegistrationValidator;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes("userCart")
public class AdministrationController {

    private final RegistrationValidator regValidator;


    private final UserService userService;


    private final TariffService tariffService;


    private final OptionService optionService;


    private final ContractService contractService;


    private final UserDetailsServiceImpl userDetailsService;

    private static Logger logger = LogManager.getLogger(AdministrationController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "/test";
    }

    @RequestMapping(value = "/administration/registration", method = RequestMethod.GET)
    public String getAdminPage(Model model) {
        UserRegistrationForm userRegForm = new UserRegistrationForm();
        model.addAttribute("user", userRegForm);
        return "administration/registration";
    }

    @RequestMapping(value = "/administration/registration", method = RequestMethod.POST)
    public String createUserByAdmin(@ModelAttribute("user") @Valid UserRegistrationForm userRegForm, BindingResult result, Model model) {
        regValidator.validate(userRegForm, result);
        if (result.hasErrors()) {
            return "/administration/registration";
        }
        userService.registerUser(userRegForm);
        List<UserAccountForm> users = userService.userAccListByCond(userRegForm.getEmail());
        model.addAttribute("users", users);
        return "redirect:/administration/users";
    }

    @RequestMapping(value = "/administration/users", method = RequestMethod.GET)
    public String getUserList(Model model) {
        UserSearch emailOrContractDTO = new UserSearch();
        model.addAttribute("emailOrContract", emailOrContractDTO);
        return "administration/users";
    }

    @RequestMapping(value = "/administration/users", method = RequestMethod.POST)
    public String getUserListByСondition(@ModelAttribute("emailOrContract") UserSearch userSearchDTO, Model model) {
        String cond = userSearchDTO.getCondition();
        List<UserAccountForm> users = userService.userAccListByCond(cond);
        model.addAttribute("users", users);
        return "administration/users";
    }

    @RequestMapping(value = "/administration/editor/user/{id}", method = RequestMethod.GET)
    public String editUser(ModelMap model, @PathVariable int id) {
        List<UserAccountForm> users = userService.getUsersById(id);
        model.addAttribute("users", users);

        return "/administration/editor/user";
    }

    @RequestMapping(value = "/administration/editor/user/{id}/addContract", method = RequestMethod.GET)
    public String addNewContract(Model model, @PathVariable int id) {
        userService.createAndAddNewContract(userService.getEntityById(id));
        return "redirect:/administration/editor/user/{id}";
    }

    @RequestMapping(value = "/administration/user/{id}/changeStatus", method = RequestMethod.POST)
    public String changeUserStatus(@PathVariable int id) {
        userService.changeUserStatus(id);
        return "redirect:/administration/editor/user/{id}";
    }
    @RequestMapping(value = "/administration/editor/{contract_id}/listTariffsToContractByAdmin", method = RequestMethod.GET)
    public String listTariffsToContractByAdmin(Model model, @PathVariable int contract_id){
        List<Contract> contracts = contractService.contractsById(contract_id);
        model.addAttribute("contracts",contracts);
        Contract contract = contractService.getEntityById(contract_id);
        model.addAttribute("tariffs",tariffService.getAll());
        contract.getUser();
        model.addAttribute("user", contract.getUser());
        return "/administration/editor/listTariffsToContractByAdmin";
    }
    //TARIFFS
    @RequestMapping(value = "/administration/tariffs", method = RequestMethod.GET)
    public String getTariffList(Model model) {
        List<Tariff> tariffs = tariffService.getAll();
        List<TariffViewForm> tariffsDTO = tariffService.getTariffViewList(tariffs);
        model.addAttribute("tariffs", tariffsDTO);
        return "administration/tariffs";
    }

    @RequestMapping(value = "/administration/editor/tariff/{id}", method = RequestMethod.GET)
    public String editTariff(Model model, @PathVariable int id) {
        List<TariffViewForm> tariffs = tariffService.tariffsByIdViewForm(id);
        model.addAttribute("tariffs", tariffs);
        return "/administration/editor/tariff";
    }

    @RequestMapping(value = "/administration/editor/tariff/{id}/image", method = RequestMethod.POST)
    public String loadNewTariffImage(@RequestParam("file") MultipartFile file, ModelMap modelMap, @PathVariable int id) throws Exception {
        Tariff tariff = tariffService.updateTariffImage(id, file);
        TariffViewForm tariffViewForm = new TariffViewForm(tariff);
        modelMap.addAttribute("tariff", tariffViewForm);
        return "redirect:/administration/editor/tariff/{id}";
    }

    @RequestMapping(value = "/administration/editor/tariff/{id}/addOption", method = RequestMethod.GET)
    public String getOptionListToAdd(Model model, @PathVariable int id) throws Exception {
        Tariff tariff = tariffService.getEntityById(id);
        TariffViewForm tariffViewForm = new TariffViewForm(tariff);
        model.addAttribute("tariff", tariffViewForm);
        //TODO optionsDTO
        List<Option> options = optionService.getAll();
        model.addAttribute("options", options);
        return "/administration/editor/listPossibleOptionsToTariff";
    }

    @RequestMapping(value = "/administration/editor/tariff/{id}/addOption/{option_id}", method = RequestMethod.POST)
    public String addNewOptionToTariff(Model model, @PathVariable int id, @PathVariable int option_id) throws Exception {
        Tariff tariff = tariffService.getEntityById(id);
        Option option = optionService.getEntityById(option_id);
        tariffService.addOption(tariff, option);
        TariffViewForm tariffViewForm = new TariffViewForm(tariff);
        model.addAttribute("tariff", tariffViewForm);
        return "redirect:/administration/editor/tariff/{id}";
    }


    @RequestMapping(value = "/administration/editor/tariff/{id}/delete/{option_id}", method = RequestMethod.POST)
    public String deleteOptionFromTariff(Model model, @PathVariable int id, @PathVariable int option_id) throws Exception {
        Tariff tariff = tariffService.getEntityById(id);
        Option option = optionService.getEntityById(option_id);
        tariffService.deleteOption(tariff, option);
        TariffViewForm tariffViewForm = new TariffViewForm(tariff);
        model.addAttribute("tariff", tariffViewForm);
        return "redirect:/administration/editor/tariff/{id}";
    }

    @RequestMapping(value = "/administration/editor/tariff/create", method = RequestMethod.GET)
    public String newTariffCreationMenu(Model model) {
        TariffViewForm tariff = new TariffViewForm();
        model.addAttribute("tariff", tariff);
        return "/administration/creation/newTariff";
    }

    @RequestMapping(value = "/administration/editor/tariff/create", method = RequestMethod.POST)
    public String createNewTariff(@ModelAttribute("tariff") TariffViewForm tariff, Model model) {
        try {
            tariffService.createNewTariff(tariff);
        } catch (Exception e) {
            //TODO logger
        }
//        model.addAttribute("tariff",tariff);
//        return "redirect:/administration/editor/tariff/{tariff.id}";
        return "redirect:/administration/tariffs";
    }

    @RequestMapping(value = "/administration/tariffs/{id}/delete", method = RequestMethod.GET)
    public String makeTariffDeprecated(@PathVariable int id) {
        tariffService.makeTariffDeprecated(id);
        return "redirect:/administration/tariffs";
    }

    @Scheduled(fixedRate = 1000 * 30) // every 30 seconds
    public void deleteUnusedDeprecatedTariffs() {
        logger.trace("Running check of deprecated tariffs...");
        tariffService.deleteDeprecatedTariffs();

    }

    //OPTIONS
    @RequestMapping(value = "/administration/options", method = RequestMethod.GET)
    public String getOptionList(Model model) {
        List<Option> options = optionService.getAll();
        //TODO optionsDTO
        model.addAttribute("options", options);
        return "administration/options";
    }

    @RequestMapping(value = "/administration/editor/option/{id}", method = RequestMethod.GET)
    public String editOption(Model model, @PathVariable int id) {
        List<Option> options = optionService.optionsById(id);
        model.addAttribute("options", options);
        return "/administration/editor/option";
    }

    @RequestMapping(value = "/administration/editor/option/{id}/associateOption", method = RequestMethod.GET)
    public String getOptionListToAssociate(Model model, @PathVariable int id) throws Exception {
        Option currentOption = optionService.getEntityById(id);
        List<Option> options = optionService.getAll();
        model.addAttribute("currentOption", currentOption);
        model.addAttribute("options", options);
        return "/administration/editor/listOptionsToAssociate";
    }

    @RequestMapping(value = "/administration/editor/option/{currentOption_id}/addOption/{id}", method = RequestMethod.POST)
    public String associateOption(@PathVariable int currentOption_id, @PathVariable int id, Model model) {
        Option curOption = optionService.getEntityById(currentOption_id);
        Option optionToAssociate = optionService.getEntityById(id);
//        curOption.associateOption(optionToAssociate);
        try {
            optionService.associateOptions(currentOption_id, id);
        }catch (OptionAssociateException e){

        }
        optionService.updateEntity(curOption);
        optionService.updateEntity(optionToAssociate);
        List<Option> options = new ArrayList<>();
        options.add(curOption);
        model.addAttribute("options", options);
        return "redirect:/administration/editor/option/{currentOption_id}";
    }

    @RequestMapping(value = "/administration/editor/option/{id}/addIncompatibleOption", method = RequestMethod.GET)
    public String getOptionListToAddIncompatible(Model model, @PathVariable int id) throws Exception {
        Option currentOption = optionService.getEntityById(id);
        List<Option> options = optionService.getAll();
        model.addAttribute("currentOption", currentOption);
        model.addAttribute("options", options);
        return "/administration/editor/listOptionsToAddIncompatible";
    }

    @RequestMapping(value = "/administration/editor/option/{currentOption_id}/addIncompatibleOption/{id}", method = RequestMethod.POST)
    public String addIncompatibleOption(@PathVariable int currentOption_id, @PathVariable int id, Model model) {
        Option curOption = optionService.getEntityById(currentOption_id);
        Option optionToIncompatible = optionService.getEntityById(id);
        curOption.addIncompatibleOption(optionToIncompatible);
        optionService.updateEntity(curOption);
        optionService.updateEntity(optionToIncompatible);
        List<Option> options = new ArrayList<>();
        options.add(curOption);
        model.addAttribute("options", options);
        return "redirect:/administration/editor/option/{currentOption_id}";
    }

    @RequestMapping(value = "/administration/editor/option/{currentOption_id}/deleteAssociatedOption/{id}", method = RequestMethod.POST)
    public String deleteAssociatedOption(@PathVariable int currentOption_id, @PathVariable int id, Model model) {
        optionService.deleteAssociatedOption(currentOption_id, id);
        List<Option> options = new ArrayList<>();
        options.add(optionService.getEntityById(currentOption_id));
        model.addAttribute("options", options);
        return "redirect:/administration/editor/option/{currentOption_id}";
    }

    @RequestMapping(value = "/administration/editor/option/{currentOption_id}/deleteIncompatibledOption/{id}", method = RequestMethod.POST)
    public String deleteIncompatibledOption(@PathVariable int currentOption_id, @PathVariable int id, Model model) {
        optionService.deleteIncompatibledOption(currentOption_id, id);
        List<Option> options = new ArrayList<>();
        options.add(optionService.getEntityById(currentOption_id));
        model.addAttribute("options", options);
        return "redirect:/administration/editor/option/{currentOption_id}";
    }

    //CONTRACTS
    @RequestMapping(value = "/administration/user/{user_id}/contract/{id}/unblock", method = RequestMethod.POST)
    public String unblockContract(@PathVariable int user_id, @PathVariable int id) {
        userService.unblockContractByAdmin(id);
        return "redirect:/administration/editor/user/{user_id}";
    }

    @RequestMapping(value = "/administration/user/{user_id}/contract/{id}/block", method = RequestMethod.POST)
    public String blockContract(@PathVariable int user_id, @PathVariable int id) {
        userService.blockContractByAdmin(id);
        return "redirect:/administration/editor/user/{user_id}";
    }

    @RequestMapping(value = "/administration/editor/{id}/addOption", method = RequestMethod.GET)
    public String listAvailableOptions(@PathVariable int id, Model model) {
        User curUser = userDetailsService.getCurrentUser();
        UserAccountForm user = new UserAccountForm(curUser);
        List<Option> options = optionService.listOfAvailableOptions(curUser.getId(), id);
        List<Contract> contracts = contractService.contractsById(id);
        model.addAttribute("contracts", contracts);
        model.addAttribute("options", options);
        model.addAttribute("user", user);
        return "/administration/editor/listOptionsToContract";
    }

    @RequestMapping(value = "/administrator/editor/{contract_id}/addOption/{option_id}", method = RequestMethod.POST)
    public String addNewOptionToContract(@PathVariable int contract_id, @PathVariable int option_id) {
        contractService.addNewOption(contract_id, option_id);
        return "redirect:/administration/editor/{contract_id}/addOption";
    }

    @RequestMapping(value = "/administration/editor/{contract_id}/deleteOption/{option_id}", method = RequestMethod.POST)
    public String deleteOptionFromContract(@PathVariable int contract_id, @PathVariable int option_id) {
        contractService.deleteOption(contract_id, option_id);
        return "redirect:/administration/editor/{contract_id}/addOption";
    }

    @RequestMapping(value = "/administration/editor/{contract_id}/listTariffsToContract", method = RequestMethod.GET)
    public String listTariffsToChange(@PathVariable int contract_id, Model model) {
        List<Tariff> tariffs = tariffService.getAll();
        List<TariffViewForm> tariffsDTO = tariffService.getTariffViewList(tariffs);
        List<Contract> contracts = contractService.contractsById(contract_id);
        User curUser = userDetailsService.getCurrentUser();
        UserAccountForm user = new UserAccountForm(curUser);
        model.addAttribute("tariffs", tariffsDTO);
        model.addAttribute("contracts", contracts);
        model.addAttribute("user", user);
        return "/administration/editor/listPossibleTariffsToContract";
    }

    @RequestMapping(value = "/administration/editor/{contract_id}/changeTariffInAccount/{tariff_id}", method = RequestMethod.GET)
    public String setTariffToContractInAccount(@PathVariable int contract_id, @PathVariable int tariff_id) {
        contractService.setTariff(contract_id, tariff_id);
        return "redirect:/auth/success";

    }
    @RequestMapping(value = "/administration/editor/{contract_id}/changeTariff/{tariff_id}/{user_id}", method = RequestMethod.GET)
    public String setTariffToContract(@PathVariable int contract_id, @PathVariable int tariff_id,@PathVariable int user_id) {
        contractService.setTariff(contract_id, tariff_id);
        return "redirect:/administration/editor/user/{user_id}";

    }

    @RequestMapping(value = "/administration/editor/{contract_id}/setTariffFromCart", method = RequestMethod.GET)
    public String setTariffFromCart(@PathVariable int contract_id, @ModelAttribute("userCart") Cart cart) {
        contractService.setTariffAndOptionsFromCart(cart,contract_id);
        return "redirect:/auth/success";
    }

    //todo to options
    @RequestMapping(value = "/administration/editor/option/create", method = RequestMethod.GET)
    public String newOptionCreationMenu(Model model) {
        Option option = new Option();
        model.addAttribute("option", option);
        return "/administration/creation/newOption";
    }

    @RequestMapping(value = "/administration/editor/option/create", method = RequestMethod.POST)
    public String createOption(@ModelAttribute("option") Option option) {
        optionService.createEntity(option);
//        model.addAttribute("option", option);
        return "redirect:/administration/options";
    }

    @RequestMapping(value = "administration/options/{id}/delete", method = RequestMethod.GET)
    public String makeOptionDeprecated(@PathVariable int id) {
        optionService.makeOptionDeprecated(id);
        return "redirect:/administration/options";
    }

    @Scheduled(fixedRate = 1000 * 30) // every 30 seconds
    public void deleteUnusedDeprecatedOptions() {
        logger.trace("Running check of deprecated options...");
        optionService.deleteDeprecatedOptions();

    }
}
