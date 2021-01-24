package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import vermolae.crud.service.api.OptionService;
import vermolae.crud.service.api.PictureService;
import vermolae.crud.service.api.TariffService;
import vermolae.crud.service.api.UserService;
import vermolae.model.dto.Picture.PictureDTO;
import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.model.dto.User.UserSearch;
import vermolae.model.entity.Option;
import vermolae.model.entity.Picture;
import vermolae.model.entity.Tariff;
import vermolae.security.UserDetailsServiceImpl;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
public class AdministrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private OptionService optionService;

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
        model.addAttribute("users", users);
        return "redirect:/administration/users";
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

    @RequestMapping(value = "/administration/editor/user/{id}", method = RequestMethod.GET)
    String editUser(Model model, @PathVariable int id) {
        UserAccountForm userAccForm = new UserAccountForm(userService.getEntityById(id));
        model.addAttribute("user", userAccForm);
        return "/administration/editor/user";
    }

    @RequestMapping(value = "/administration/editor/user/{id}/addContract", method = RequestMethod.GET)
    String addNewContract(Model model, @PathVariable int id) {
        userService.createAndAddNewContract(userService.getEntityById(id));
        return "redirect:/administration/editor/user/{id}";
    }

    //TARIFFS
    @RequestMapping(value = "/administration/tariffs", method = RequestMethod.GET)
    String getTariffList(Model model) {
//        Option option = optionService.getEntityById(1);
//        Tariff tariff = tariffService.getEntityById(1);
//        tariffService.addOption(tariff,option);
//        tariffService.updateTariff(tariff);
        List<Tariff> tariffs = tariffService.getAll();
        List<TariffViewForm> tariffsDTO = tariffService.getTariffViewList(tariffs);
        model.addAttribute("tariffs", tariffsDTO);
        return "administration/tariffs";
    }

    @RequestMapping(value = "/administration/editor/tariff/{id}", method = RequestMethod.GET)
    String editTariff(Model model, @PathVariable int id) {
        TariffViewForm tariffViewForm = new TariffViewForm(tariffService.getEntityById(id));
        model.addAttribute("tariff", tariffViewForm);
        return "/administration/editor/tariff";
    }

    @RequestMapping(value = "/administration/editor/tariff/{id}/image", method = RequestMethod.POST)
    String loadNewTariffImage(@RequestParam("file") MultipartFile file, ModelMap modelMap, @PathVariable int id) throws Exception {
        Tariff tariff = tariffService.updateTariffImage(id, file);
        TariffViewForm tariffViewForm = new TariffViewForm(tariff);
        modelMap.addAttribute("tariff", tariffViewForm);
        return "redirect:/administration/editor/tariff/{id}";
    }

    @RequestMapping(value = "/administration/editor/tariff/{id}/addOption", method = RequestMethod.POST)
    String addNewOptionToTariff(ModelMap modelMap, @PathVariable int id) throws Exception {
        Tariff tariff = tariffService.getEntityById(id);

        TariffViewForm tariffViewForm = new TariffViewForm(tariff);
        modelMap.addAttribute("tariff", tariffViewForm);
        return "redirect:/administration/editor/tariff/{id}";
    }

    //OPTIONS
    @RequestMapping(value = "/administration/options", method = RequestMethod.GET)
    String getOptionList(Model model) {
        List<Option> options = optionService.getAll();
        //TODO optionsDTO
        model.addAttribute("options", options);
        return "administration/options";
    }



}
