package vermolae.crud.service.api;

import org.springframework.web.multipart.MultipartFile;
import vermolae.model.dto.Tariff.TariffForStand;
import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.entity.Option;
import vermolae.model.entity.Tariff;

import java.util.Collection;
import java.util.List;


public interface TariffService extends GenericService<Tariff, Integer> {

    List<TariffViewForm> getTariffViewList(Collection<Tariff> tariffs);

    void updateTariff(Tariff tariff);

    Tariff updateTariffImage(int TariffId, MultipartFile file) throws Exception;

    void addOption(Tariff tariff, Option option);

    void deleteOption(Tariff tariff, Option option);

    List<Tariff> tariffsById(int id);

    List<TariffViewForm> tariffsByIdViewForm(int id);

    void createNewTariff(TariffViewForm tariff) throws Exception;

    void deleteDeprecatedTariffs();

    List<Tariff> deprecatedTariffs();

    void makeTariffDeprecated(int id);

    List<TariffForStand> tariffsForStand();
}
