package vermolae.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vermolae.crud.service.api.OptionService;
import vermolae.crud.service.api.TariffService;
import vermolae.model.Cart.Cart;
import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.entity.Tariff;

import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes("userCart")
public class TariffController {

    private final TariffService tariffService;
    private final OptionService optionService;

    @GetMapping("/tariff")
    public String getTariffsPage(Model model){
        List<Tariff> tariffs = tariffService.getAll();
        List<TariffViewForm> tariffViewFormList = tariffService.getTariffViewList(tariffs);
        model.addAttribute("tariffs",tariffViewFormList );
        return "tariffs";
    }

    @GetMapping("/tariff/{id}")
    public String getTariffPageById(@PathVariable int id,Model model,@ModelAttribute("userCart") Cart cart){
        Collection<Tariff> tariffs = tariffService.tariffsById(id);
        List<TariffViewForm> tariffViewFormList = tariffService.getTariffViewList(tariffs);
        model.addAttribute("userCart", cart);
        model.addAttribute("tariffs",tariffViewFormList );
        return "tariff";
    }
    @ModelAttribute("userCart")
    public Cart createUser() {
        return new Cart();
    }
    @RequestMapping(value="/tariff/{tariff_id}/option/{option_id}/addToCart", method=RequestMethod.POST)
    public String addOptionToCart(@ModelAttribute("userCart") Cart cart,@PathVariable int tariff_id,@PathVariable int option_id){
        cart.setTariff(tariffService.getEntityById(tariff_id));
        cart.getOptions().add(optionService.getEntityById(option_id));
        return "redirect:/tariff/{tariff_id}";
    }
    }

