package vermolae.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vermolae.crud.dao.api.OptionDAO;
import vermolae.crud.service.api.OptionService;
import vermolae.exeptions.CustomDAOException;
import vermolae.model.entity.Option;

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
    public void updateEntity(Option entity) throws CustomDAOException {

    }

    @Override
    public void deleteEntity(Option entity) throws CustomDAOException {

    }

    @Override
    @Transactional
    public List<Option> getAll() throws CustomDAOException {
        return optionDAO.getAll();
    }
}
