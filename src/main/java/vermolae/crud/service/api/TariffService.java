package vermolae.crud.service.api;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.entity.Option;
import vermolae.model.entity.Tariff;
import vermolae.model.entity.User;

import java.io.IOException;
import java.util.Collection;
import java.util.List;


public interface TariffService extends GenericService<Tariff, Integer> {

    //get tariff by contract
    public List<TariffViewForm> getTariffViewList(Collection<Tariff> tariffs);

    public void updateTariff(Tariff tariff);

    public Tariff updateTariffImage(int TariffId, MultipartFile file) throws Exception;

    public void addOption(Tariff tariff, Option option);

    public void deleteOption(Tariff tariff, Option option);

    public List<Tariff> tariffsById(int id);

    public List<TariffViewForm> tariffsByIdViewForm(int id);

    public void createNewTariff(TariffViewForm tariff) throws Exception;

    public void deleteDeprecatedTariffs();

    public List<Tariff> deprecatedTariffs();

    void makeTariffDeprecated(int id);
}
