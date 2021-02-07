package vermolae.controller;


import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vermolae.crud.dao.api.PictureDAO;
import vermolae.crud.service.api.TariffService;
import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.entity.Tariff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class TariffController {

    private final TariffService tariffService;

    @GetMapping("/tariff")
    public String getTariffsPage(Model model){
        List<Tariff> tariffs = tariffService.getAll();
        List<TariffViewForm> tariffViewFormList = tariffService.getTariffViewList(tariffs);
        model.addAttribute("tariffs",tariffViewFormList );
        return "tariffs";
    }

    @GetMapping("/tariff/{id}")
    public String getTariffPageById(@PathVariable int id,Model model){
        Collection<Tariff> tariffs = tariffService.tariffsById(id);
        List<TariffViewForm> tariffViewFormList = tariffService.getTariffViewList(tariffs);
        model.addAttribute("tariffs",tariffViewFormList );
        return "tariff";
    }
    }

