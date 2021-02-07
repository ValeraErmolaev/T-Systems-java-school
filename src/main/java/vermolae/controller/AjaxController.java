package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vermolae.crud.service.api.TariffService;
import vermolae.model.entity.Tariff;
import vermolae.model.entity.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AjaxController {

    @Autowired
    private TariffService tariffService;

    @RequestMapping(value = "/show.ajax", method = RequestMethod.GET)
    public String ajaxPage() {

        return "test";
    };
    @RequestMapping(value = "/show.ajax", method = RequestMethod.POST)
    public @ResponseBody     List<Tariff> getAjaxUsers() {
        ArrayList<User> users = new ArrayList<>();
        List<Tariff> tariffs = tariffService.getAll();
//       users.add(userService.getEntityById(18));

        return tariffs;
    }
}
