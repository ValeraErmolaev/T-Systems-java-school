package vermolae.controller;


import org.apache.commons.io.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vermolae.crud.dao.api.PictureDAO;
import vermolae.crud.service.api.TariffService;
import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.entity.Tariff;
import java.util.List;

@Controller
public class TariffController {

    @Autowired
    private TariffService tariffService;

    //todO here must be service!!1
    @Autowired
    PictureDAO pictureDAO;

    @GetMapping("/tariff")
    public String getTariffsPage(Model model) throws Exception{
        List<Tariff> tariffs = tariffService.getAll();
        List<TariffViewForm> tariffViewFormList = tariffService.getTariffViewList(tariffs);
        model.addAttribute("tariffs",tariffViewFormList );
        return "tariffs";
    }

    @PostMapping("/tariff")
    public @ResponseBody List<Tariff> getAjaxTariffs () {
        List<Tariff>   tariffs = tariffService.getAll();
            return tariffs;
        }
    }

