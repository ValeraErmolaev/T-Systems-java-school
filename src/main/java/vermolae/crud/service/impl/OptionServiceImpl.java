package vermolae.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vermolae.crud.dao.api.OptionDAO;
import vermolae.crud.service.api.OptionService;
import vermolae.exeptions.CustomDAOException;
import vermolae.model.entity.Option;
import vermolae.model.entity.Tariff;

import java.util.ArrayList;
import java.util.List;

@Service("optionService")
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionDAO optionDAO;

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
}
