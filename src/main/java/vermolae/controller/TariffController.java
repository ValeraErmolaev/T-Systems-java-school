package vermolae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vermolae.crud.service.api.TariffService;
import vermolae.model.entity.Tariff;
import vermolae.model.entity.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TariffController {

    @Autowired
    private TariffService tariffService;

    @GetMapping("/tariff")
    public String getTariffsPage(Model model) {
        List<Tariff>   tariffs = tariffService.getAll();
        model.addAttribute("tariffslist",tariffs );
        return "tariffs";
    }

    @PostMapping("/tariff")
    public @ResponseBody List<Tariff> getAjaxUsers () {
        List<Tariff>   tariffs = tariffService.getAll();
            return tariffs;
        }
    }

