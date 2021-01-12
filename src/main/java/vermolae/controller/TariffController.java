package vermolae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TariffController {

    @GetMapping("/tariff")
    public String getTariffs() {
        return "tariffs";
    }
}
