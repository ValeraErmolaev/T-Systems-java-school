package vermolae.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vermolae.crud.dao.api.ContractDAO;
import vermolae.crud.dao.api.TariffDAO;
import vermolae.crud.dao.impl.ContractDAOImpl;
import vermolae.crud.service.api.ContractService;
import vermolae.exeptions.CustomDAOException;
import vermolae.exeptions.DatabaseOfNumbersIsFull;
import vermolae.model.entity.Contract;
import vermolae.model.entity.Tariff;
import vermolae.model.entity.User;

import java.util.ArrayList;
import java.util.List;
@Service("contractService")
public class ContractServiceImpl implements ContractService {

    @Autowired
    private TariffDAO tariffDAO;

    @Autowired
    private ContractDAO contractDAO;

    @Override
    public void createEntity(Contract entity) throws CustomDAOException {
        contractDAO.create(entity);
    }

    @Override
    @Transactional
    public Contract getEntityById(Integer id) throws CustomDAOException {
        return contractDAO.read(id);
    }

    @Override
    @Transactional
    public void updateEntity(Contract entity) throws CustomDAOException {
        contractDAO.update(entity);

    }

    @Override
    public void deleteEntity(Contract entity) throws CustomDAOException {

    }

    @Override
    public List<Contract> getAll() throws CustomDAOException {
        return contractDAO.getAll();
    }

    @Override
    public String getRandomNumber() {
       List<Contract> contracts = getAll();
        if (contracts.size()==8999999) {
            throw new DatabaseOfNumbersIsFull("All possible numbers are used.");
        }
        StringBuffer startNumber = new StringBuffer("+7999");
        StringBuffer newNumber = new StringBuffer("");
        int min = 1000000;
        int max = 9999999;
        do {
            Integer randomNumber = (int) (Math.random() * (max - min + 1) + min);
            newNumber = startNumber.append(randomNumber.toString());
        } while (contracts.contains(newNumber.toString()));
        return newNumber.toString();
    }

    @Override
    public void createNewDefaultContract(User user, String number) {
        Contract contract = new Contract();
        contract.setNumber(number);
        contract.setTariff(tariffDAO.read(1));
//        contract.setUser(user);
        createEntity(contract);
        user.addContract(contract);
    }
}
