package vermolae.crud.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import vermolae.crud.dao.api.TariffDAO;
import vermolae.crud.service.api.OptionService;
import vermolae.crud.service.api.PictureService;
import vermolae.crud.service.api.TariffService;
import vermolae.exeptions.CustomDAOException;
import vermolae.exeptions.TariffNotFoundException;
import vermolae.model.dto.Tariff.TariffForStand;
import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.entity.Option;
import vermolae.model.entity.Picture;
import vermolae.model.entity.Tariff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service("tariffService")
@RequiredArgsConstructor
public class TariffServiceImpl implements TariffService {

    private final TariffDAO tariffDAO;

    private final PictureService pictureService;

    private final OptionService optionService;

    private static final Logger logger = LogManager.getLogger(TariffServiceImpl.class);


    @Override
    @Transactional
    public void createEntity(Tariff entity) throws CustomDAOException {
        tariffDAO.create(entity);
    }

    @Override
    @Transactional
    public Tariff getEntityById(Integer id) throws TariffNotFoundException {
        return tariffDAO.read(id);
    }

    @Override
    @Transactional
    public void updateEntity(Tariff entity) throws CustomDAOException {
        tariffDAO.update(entity);
    }

    @Override
    public void deleteEntity(Tariff entity) throws CustomDAOException {
        tariffDAO.delete(entity);
    }

    @Override
    @Transactional
    public List<Tariff> getAll() throws CustomDAOException {
        return tariffDAO.getAll();
    }

    @Override
    @Transactional
    public List<TariffViewForm> getTariffViewList(Collection<Tariff> tariffs) {
        List<TariffViewForm> tariffViewFormList = new ArrayList<>();
        try {
            for (Tariff tariff : tariffs) {
                tariffViewFormList.add(new TariffViewForm(tariff));
            }
            return tariffViewFormList;
        } catch (Exception e) {
            return tariffViewFormList;
        }
    }

    @Override
    @Transactional
    public void updateTariff(Tariff tariff) {
        tariffDAO.update(tariff);
    }

    @Override
    @Transactional
    public Tariff updateTariffImage(int TariffId, MultipartFile file) throws Exception {
        Tariff tariff = getEntityById(TariffId);


        String filename = file.getOriginalFilename();
        pictureService.saveNewPicture(filename, file);
        Picture pictureNew = pictureService.getPictureByName(filename);
        tariff.setPicture(pictureNew);
        updateTariff(tariff);
        return tariff;
    }

    @Override
    @Transactional
    public void addOption(Tariff tariff, Option option) {
        tariff.addOption(option);
        for (Option opt : option.getAssociatedOptions()) {
            tariff.addOption(opt);
        }
        updateEntity(tariff);
    }

    @Override
    @Transactional
    public void deleteOption(Tariff tariff, Option option) {
        tariff.getOptions().remove(option);
        for (Option opt : option.getAssociatedOptions()) {
            tariff.getOptions().remove(opt);
        }
        tariffDAO.update(tariff);
    }

    @Override
    @Transactional
    public List<Tariff> tariffsById(int id) throws TariffNotFoundException {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        try {
            tariffs.add(getEntityById(id));
        } catch (Exception e) {
            return tariffs;
        }
        return tariffs;
    }

    @Override
    public List<TariffViewForm> tariffsByIdViewForm(int id) {
        List<TariffViewForm> tariffsDTO = new ArrayList<>();
        List<Tariff> tariffs = new ArrayList<>();
        try {
            tariffs.add(tariffDAO.read(id));
            for (Tariff tariff : tariffs) {
                tariffsDTO.add(new TariffViewForm(tariff));
            }
        } catch (Exception e) {
            logger.trace(e);
            return tariffsDTO;
        }

        return tariffsDTO;
    }

    @Override
    @Transactional
    public void createNewTariff(TariffViewForm tariff) throws Exception {
        Tariff newTariff = new Tariff();
        newTariff.setName(tariff.getName());
        newTariff.setDescription(tariff.getDescription());
        newTariff.setPrice(tariff.getPrice());
        newTariff.setTurnonprice(tariff.getTurnOnPrice());
        newTariff.setPicture(pictureService.getDefaultPicture());
        createEntity(newTariff);
    }

    @Override
    @Transactional
    public void deleteDeprecatedTariffs() {
        List<Tariff> deprecatedTariffs = deprecatedTariffs();
        if (deprecatedTariffs.size() != 0) {
            for (Tariff tariff : deprecatedTariffs) {
                String name = tariff.getName();
                if (tariff.getContracts().size() == 0) {
                    for (Option option : tariff.getOptions()) {
                        option.getTariffs().remove(tariff);
                        optionService.updateEntity(option);
                    }
                    deleteEntity(tariff);
                    logger.trace(name +" tariff was removed.");
                }
            }
        }

    }

    @Override
    @Transactional
    public List<Tariff> deprecatedTariffs() {
        return getAll().stream().filter(Tariff::isDeprecated).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void makeTariffDeprecated(int id) {
        Tariff tariff = getEntityById(id);
        tariff.setDeprecated(true);
        updateEntity(tariff);
    }

    @Override
    @Transactional
    public List<TariffForStand> tariffsForStand() {
        List<TariffForStand> tariffsForStand = new ArrayList<>();
        for (Tariff tariff:getAll()){
            tariffsForStand.add(new TariffForStand(tariff));
        }
        return tariffsForStand;
    }
}
