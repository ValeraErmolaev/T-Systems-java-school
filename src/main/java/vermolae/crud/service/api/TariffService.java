package vermolae.crud.service.api;

import org.springframework.web.multipart.MultipartFile;
import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.entity.Option;
import vermolae.model.entity.Tariff;

import java.io.IOException;
import java.util.List;


public interface TariffService extends GenericService<Tariff, Integer>{

    //get tariff by contract
    List<TariffViewForm> getTariffViewList(List<Tariff> tariffs);

    void updateTariff (Tariff tariff);

    public Tariff updateTariffImage(int TariffId, MultipartFile file) throws Exception;
    public void addOption(Tariff tariff,Option option);
}
