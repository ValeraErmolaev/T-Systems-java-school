package vermolae.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vermolae.crud.dao.api.OptionDAO;
import vermolae.crud.service.api.ContractService;
import vermolae.crud.service.api.OptionService;
import vermolae.crud.service.api.UserService;
import vermolae.exeptions.CustomDAOException;
import vermolae.model.entity.Contract;
import vermolae.model.entity.Option;
import vermolae.model.entity.Tariff;
import vermolae.model.entity.User;
import vermolae.security.UserDetailsServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Service("optionService")
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionDAO optionDAO;

    @Autowired
    private ContractService contractService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserService userService;

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
    public void deleteEntity(Option entity) throws CustomDAOException {

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
        User user = userService.getEntityById(user_id);
        User currentUser = userDetailsService.getCurrentUser();
        if (user.equals(currentUser)) {
            try {
                Contract contract = contractService.getEntityById(contract_id);
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
}

