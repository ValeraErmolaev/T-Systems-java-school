package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vermolae.crud.service.api.OptionService;
import vermolae.crud.service.api.TariffService;
import vermolae.crud.service.api.UserService;
import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.model.dto.User.UserSearch;
import vermolae.model.entity.Option;
import vermolae.model.entity.Tariff;
import vermolae.validator.RegistrationValidator;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdministrationController {
    @Autowired
    private RegistrationValidator regValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private OptionService optionService;

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
//        UserSearch emailOrContractDTO = new UserSearch();
//        emailOrContractDTO.setCondition(userRegForm.getEmail());
        List<UserAccountForm> users = userService.userAccListByCond(userRegForm.getEmail());
//        model.addAttribute("emailOrContract", emailOrContractDTO);
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
//        UserAccountForm user = new UserAccountForm(userService.getEntityById(id));
        List<UserAccountForm> users = userService.getUsersById(id);
//        User user = userService.getEntityById(id);
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
    public String getOptionListToAssociate(Model model, @PathVariable int id) throws Exception{
        Option currentOption = optionService.getEntityById(id);
        List<Option> options = optionService.getAll();
        model.addAttribute("currentOption", currentOption);
        model.addAttribute("options",options);
        return "/administration/editor/listOptionsToAssociate";
    }
    @RequestMapping(value = "/administration/editor/option/{currentOption_id}/addOption/{id}", method = RequestMethod.POST)
    public String associateOption(@PathVariable int currentOption_id, @PathVariable int id, Model model){
        Option curOption = optionService.getEntityById(currentOption_id);
        Option optionToAssociate = optionService.getEntityById(id);
//        curOption.associateOption(optionToAssociate);
        optionService.associateOptions(currentOption_id,id);
        optionService.updateEntity(curOption);
        optionService.updateEntity(optionToAssociate);
        List<Option> options = new ArrayList<>();
        options.add(curOption);
        model.addAttribute("options",options);
        return "redirect:/administration/editor/option/{currentOption_id}";
    }

    @RequestMapping(value = "/administration/editor/option/{id}/addIncompatibleOption", method = RequestMethod.GET)
    public String getOptionListToAddIncompatible(Model model, @PathVariable int id) throws Exception{
        Option currentOption = optionService.getEntityById(id);
        List<Option> options = optionService.getAll();
        model.addAttribute("currentOption", currentOption);
        model.addAttribute("options",options);
        return "/administration/editor/listOptionsToAddIncompatible";
    }

    @RequestMapping(value = "/administration/editor/option/{currentOption_id}/addIncompatibleOption/{id}", method = RequestMethod.POST)
    public String addIncompatibleOption(@PathVariable int currentOption_id, @PathVariable int id, Model model){
        Option curOption = optionService.getEntityById(currentOption_id);
        Option optionToIncompatible = optionService.getEntityById(id);
        curOption.addIncompatibleOption(optionToIncompatible);
        optionService.updateEntity(curOption);
        optionService.updateEntity(optionToIncompatible);
        List<Option> options = new ArrayList<>();
        options.add(curOption);
        model.addAttribute("options",options);
        return "redirect:/administration/editor/option/{currentOption_id}";
    }
    @RequestMapping(value = "/administration/editor/option/{currentOption_id}/deleteAssociatedOption/{id}" , method = RequestMethod.POST)
    public String deleteAssociatedOption(@PathVariable int currentOption_id, @PathVariable int id, Model model){
        optionService.deleteAssociatedOption(currentOption_id,id);
        List<Option> options = new ArrayList<>();
        options.add(optionService.getEntityById(currentOption_id));
        model.addAttribute("options",options);
        return "redirect:/administration/editor/option/{currentOption_id}";
    }
    @RequestMapping(value = "/administration/editor/option/{currentOption_id}/deleteIncompatibledOption/{id}" , method = RequestMethod.POST)
    public String deleteIncompatibledOption(@PathVariable int currentOption_id, @PathVariable int id, Model model){
        optionService.deleteIncompatibledOption(currentOption_id,id);
        List<Option> options = new ArrayList<>();
        options.add(optionService.getEntityById(currentOption_id));
        model.addAttribute("options",options);
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
}
