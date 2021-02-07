package vermolae.crud.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vermolae.controller.AdministrationController;
import vermolae.crud.dao.api.ContractDAO;
import vermolae.crud.dao.api.OptionDAO;
import vermolae.crud.dao.api.TariffDAO;
import vermolae.crud.dao.api.UserDAO;
import vermolae.crud.service.api.ContractService;
import vermolae.crud.service.api.OptionService;
import vermolae.crud.service.api.UserService;
import vermolae.exeptions.CustomDAOException;
import vermolae.exeptions.OptionAssociateException;
import vermolae.model.entity.Contract;
import vermolae.model.entity.Option;
import vermolae.model.entity.Tariff;
import vermolae.model.entity.User;
import vermolae.security.UserDetailsServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("optionService")
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService {

    private final OptionDAO optionDAO;

    private final ContractDAO contractDAO;

    private final UserDetailsServiceImpl userDetailsService;

    private final TariffDAO tariffDAO;

    private final UserDAO userDAO;

    private static Logger logger = LogManager.getLogger(OptionServiceImpl.class);

    @Override
    @Transactional
    public void createEntity(Option entity) throws CustomDAOException {
        optionDAO.create(entity);
    }

    @Override
    @Transactional
    public Option getEntityById(Integer id) throws CustomDAOException {
        return optionDAO.read(id);
    }

    @Override
    @Transactional
    public void updateEntity(Option entity) throws CustomDAOException {
        optionDAO.update(entity);
    }

    @Override
    @Transactional
    public void deleteEntity(Option entity) throws CustomDAOException {
        optionDAO.delete(entity);
    }

    @Override
    @Transactional
    public List<Option> getAll() throws CustomDAOException {
        return optionDAO.getAll();
    }

    @Override
    @Transactional
    public List<Option> optionsById(int id) {
        List<Option> options = new ArrayList<>();
        try {
            options.add(getEntityById(id));
        } catch (Exception e) {
            return options;
        }
        return options;
    }

    @Override
    @Transactional
    public List<Option> listOfAvailableOptions(int user_id, int contract_id) {
        List<Option> options = new ArrayList<>();
        User user = userDAO.read(user_id);
        User currentUser = userDetailsService.getCurrentUser();
        if (user.equals(currentUser)) {
            try {
                Contract contract = contractDAO.read(contract_id);
                Tariff tariff = contract.getTariff();
                for (Option option : tariff.getOptions()) {
                    if (!contract.getOptions().contains(option)) {
                        options.add(option);
                    }
                }
            } catch (Exception e) {
                return options;

            }
        }
        return options;
    }

    @Override
    @Transactional
    public void associateOptions(int option_first_id, int option_second_id) throws OptionAssociateException {
        Option optionFirst = getEntityById(option_first_id);
        Option optionSecond = getEntityById(option_second_id);
        Set<Option> optionsAssocWithSecond = optionSecond.getAssociatedOptions();
        Set<Option> optionsAssocWithFirst = optionFirst.getAssociatedOptions();
//        if (optionFirst.getIncompatibledOptions().contains(optionSecond)) {
//            throw new OptionAssociateException("Options " + optionFirst.getName() + " " +
//                    optionSecond.getName() + " are incompatible. ");
//        }
        for (Option assocToFirstOpt : optionFirst.getAssociatedOptions()) {
            for (Option incompatOption : assocToFirstOpt.getIncompatibledOptions()) {
                if (incompatOption.equals(optionSecond) || optionsAssocWithSecond.contains(incompatOption)) {
                    throw new OptionAssociateException("Options " + optionFirst.getName() + " and " +
                            optionSecond.getName() + " are incompatible. ");
                }
            }
        }
        if (!optionFirst.equals(optionSecond)) {
            optionFirst.associateOption(optionSecond);
        }

        for (Option optionAssociatedWithSecond : optionSecond.getAssociatedOptions()) {
            if (!optionFirst.equals(optionAssociatedWithSecond)) {
                optionFirst.associateOption(optionAssociatedWithSecond);
//            updateEntity(optionFirst);
//            updateEntity(optionAssociatedWithSecond);
            }

        }
        for (Option optionAssociatedWithFirst : optionsAssocWithFirst) {
            for (Option optionAssociatedWithSecond : optionsAssocWithSecond) {
                if (!optionAssociatedWithFirst.equals(optionAssociatedWithSecond)) {
                    optionAssociatedWithFirst.associateOption(optionAssociatedWithSecond);
//                updateEntity(optionAssociatedWithFirst);
//                updateEntity(optionAssociatedWithSecond);
                }

            }
            if (!optionAssociatedWithFirst.equals(optionSecond)) {
                optionAssociatedWithFirst.associateOption(optionSecond);
//            updateEntity(optionAssociatedWithFirst);
//            updateEntity(optionSecond);
            }

        }
        updateEntity(optionFirst);
        for (Option newAssociatedOptions : optionFirst.getAssociatedOptions()) {
            updateEntity(newAssociatedOptions);
        }
//        updateEntity(optionSecond);
    }

    @Override
    @Transactional
    public void deleteAssociatedOption(int currentOption_id, int option_id) {
        Option currentOption = getEntityById(currentOption_id);
        Option option = getEntityById(option_id);
        currentOption.getAssociatedOptions().remove(option);
        for (Option assocWithCurrentOption : currentOption.getAssociatedOptions()) {
            assocWithCurrentOption.getAssociatedOptions().remove(option);
            option.getAssociatedOptions().remove(assocWithCurrentOption);
            updateEntity(assocWithCurrentOption);
        }
        option.getAssociatedOptions().remove(currentOption);
        updateEntity(currentOption);
        updateEntity(option);
    }

    @Override
    @Transactional
    public void deleteIncompatibledOption(int currentOption_id, int option_id) {
        Option currentOption = getEntityById(currentOption_id);
        Option option = getEntityById(option_id);
        currentOption.getIncompatibledOptions().remove(option);
        option.getIncompatibledOptions().remove(currentOption);
        updateEntity(currentOption);
        updateEntity(option);
    }

    @Override
    @Transactional
    public void makeOptionDeprecated(int id) {
        Option option = getEntityById(id);
        option.setIs_deprecated(true);
        updateEntity(option);
    }

    @Override
    @Transactional
    public void deleteDeprecatedOptions() {
        List<Option> deprecatedOpt = deprecatedOptions();
        if (deprecatedOpt.size() != 0) {
            for (Option option : deprecatedOpt) {
                String name = option.getName();
                if (option.getContracts().size() == 0) {
                    for (Tariff tariff : option.getTariffs()) {
                        tariff.getOptions().remove(option);
                        tariffDAO.update(tariff);
                    }
                    for (Option assocOpt : option.getAssociatedOptions()) {
                        assocOpt.getAssociatedOptions().remove(option);
                        updateEntity(option);
                    }
                    for (Option incompOpt : option.getIncompatibledOptions()) {
                        incompOpt.getIncompatibledOptions().remove(option);
                        updateEntity(option);
                    }
                    deleteEntity(option);
                    logger.trace(String.format(name +" option was removed."));
                }
            }
        }

    }

    @Override
    @Transactional
    public List<Option> deprecatedOptions() {
        return getAll().stream().filter(option -> option.isIs_deprecated()).collect(Collectors.toList());
    }
}

