package vermolae.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vermolae.crud.service.api.TariffService;
import vermolae.model.dto.Tariff.TariffForStand;
import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.entity.Tariff;
import vermolae.model.entity.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ClientController {

    private final TariffService tariffService;

    @RequestMapping(value = "/allTariffs", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> allTariffs() {
        final List<TariffForStand> tariffs = tariffService.tariffsForStand();
        return !tariffs.isEmpty() ? new ResponseEntity<>(tariffs, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
