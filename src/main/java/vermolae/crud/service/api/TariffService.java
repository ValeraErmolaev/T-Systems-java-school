package vermolae.crud.service.api;

import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.entity.Tariff;

import java.util.List;


public interface TariffService extends GenericService<Tariff, Integer>{

    //get tariff by contract
    List<TariffViewForm> getTariffViewList(List<Tariff> tariffs);

    void updateTariff (Tariff tariff);
}
