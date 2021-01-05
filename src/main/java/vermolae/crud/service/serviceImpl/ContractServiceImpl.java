package vermolae.crud.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vermolae.crud.service.serviceApi.ContractService;
import vermolae.dao.daoImpl.ContractDAOImpl;
import vermolae.dao.dao_new.ContractDAO;
import vermolae.entity.Contract;
import vermolae.exeptions.CustomDAOException;

import java.util.List;
@Service("contractService")
//@Transactional
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDAOImpl contractDAO;

    @Override
//    @Transactional(readOnly = false)
    public void createEntity(Contract entity) throws CustomDAOException {
            contractDAO.create(entity);


    }

    @Override
//    @Transactional
    public Contract getEntityById(Integer id) throws CustomDAOException {
        return null;
    }

    @Override
//    @Transactional
    public void updateEntity(Contract entity) throws CustomDAOException {

    }

    @Override
//    @Transactional
    public void deleteEntity(Contract entity) throws CustomDAOException {

    }

    @Override
//    @Transactional
    public List<Contract> getAll() throws CustomDAOException {
        return null;
    }
}
