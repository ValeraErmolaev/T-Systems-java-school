package vermolae.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vermolae.crud.dao.api.TariffDAO;
import vermolae.crud.service.api.TariffService;
import vermolae.exeptions.CustomDAOException;
import vermolae.model.entity.Tariff;

import java.util.List;

@Service("tariffService")
public class TariffServiceImpl implements TariffService {

    @Autowired
    private TariffDAO tariffDAO;

    @Override
    public void createEntity(Tariff entity) throws CustomDAOException {

    }

    @Override
    public Tariff getEntityById(Integer id) throws CustomDAOException {
        return null;
    }

    @Override
    public void updateEntity(Tariff entity) throws CustomDAOException {

    }

    @Override
    public void deleteEntity(Tariff entity) throws CustomDAOException {

    }

    @Override
    @Transactional
    public List<Tariff> getAll() throws CustomDAOException {
        return tariffDAO.getAll();
    }
}
