package vermolae.crud.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vermolae.crud.dao.api.ContractDAO;
import vermolae.crud.service.api.ContractService;
import vermolae.crud.service.api.OptionService;
import vermolae.crud.service.api.TariffService;
import vermolae.exeptions.CustomDAOException;
import vermolae.exeptions.DatabaseOfNumbersIsFull;
import vermolae.model.Cart.Cart;
import vermolae.model.Enum.Role;
import vermolae.model.dto.Tariff.TariffForStand;
import vermolae.model.entity.Contract;
import vermolae.model.entity.Option;
import vermolae.model.entity.Tariff;
import vermolae.model.entity.User;
import vermolae.network.Sender;
import vermolae.security.UserDetailsServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("contractService")
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final TariffService tariffService;

    private final ContractDAO contractDAO;

    private final OptionService optionService;

    private final Sender sender;

    private final UserDetailsServiceImpl userDetailsService;


    @Override
    @Transactional
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
    @Transactional
    public List<Contract> getAll() throws CustomDAOException {
        return contractDAO.getAll();
    }

    @Override
    public String getRandomNumber() {
        List<Contract> contracts = getAll();
        if (contracts.size() == 8999999) {
            throw new DatabaseOfNumbersIsFull("All possible numbers are used.");
        }
        StringBuilder startNumber = new StringBuilder("+7999");
        StringBuilder newNumber;
        int min = 1000000;
        int max = 9999999;
        do {
            int randomNumber = (int) (Math.random() * (max - min + 1) + min);
            newNumber = startNumber.append(randomNumber);
        } while (contracts.contains(newNumber.toString()));
        return newNumber.toString();
    }

    @Override
    @Transactional
    public void createNewDefaultContract(User user, String number) {
        Contract contract = new Contract();
        contract.setNumber(number);
        contract.setTariff(tariffService.getEntityById(1));
        contract.setUser(user);
        createEntity(contract);
        user.addContract(contract);
    }

    @Override
    @Transactional
    public List<Contract> contractsById(int id) {
        List<Contract> contracts = new ArrayList<>();
        try {
            contracts.add(getEntityById(id));
        } catch (Exception e) {
            return contracts;
        }
        return contracts;
    }

    @Override
    @Transactional
    public void addNewOption(int contract_id, int option_id) {
        Contract contract = getEntityById(contract_id);
        Option option = optionService.getEntityById(option_id);
        Set<Option> contractOptions = contract.getOptions();
        Set<Option> optionsToDelete = option.getIncompatibledOptions();
        Set<Option> optionsToAdd = option.getAssociatedOptions();
        for (Option optToDel : optionsToDelete) {
            if (contractOptions.contains(optToDel)) {
                contractOptions.remove(optToDel);
                for (Option assocOptToOptToDel : optToDel.getAssociatedOptions()) {
                    if (contractOptions.contains(assocOptToOptToDel)) {
                        contractOptions.remove(assocOptToOptToDel);
                        assocOptToOptToDel.getContracts().remove(contract);
                        optionService.updateEntity(assocOptToOptToDel);
                    }
                }
                optToDel.getContracts().remove(contract);
                optionService.updateEntity(optToDel);
            }
//            deleteOption(contract_id,optToDel.getId());
        }
        contract.getOptions().add(option);
        option.getContracts().add(contract);
        for (Option optToAdd : optionsToAdd) {
            contract.getOptions().add(optToAdd);
            optToAdd.getContracts().add(contract);
            optionService.updateEntity(optToAdd);
        }

        updateEntity(contract);
        optionService.updateEntity(option);
    }

    @Override
    public void deleteOption(int contract_id, int option_id) {
        Contract contract = getEntityById(contract_id);
        Option option = optionService.getEntityById(option_id);
        Set<Option> contractOptions = contract.getOptions();
        for (Option optToDel : option.getAssociatedOptions()) {
            if (contractOptions.contains(optToDel)) {
                contractOptions.remove(optToDel);
                optToDel.getContracts().remove(contract);
                optionService.updateEntity(optToDel);
            }
        }
        contractOptions.remove(option);
        option.getContracts().remove(contract);
        updateEntity(contract);
        optionService.updateEntity(option);
    }

    @Override
    @Transactional
    public void setTariff(int contract_id, int tariff_id) {
        TariffForStand tariffForStandOld = new TariffForStand(tariffService.getEntityById(tariff_id));
        User currentUser = userDetailsService.getCurrentUser();
        List<Contract> contracts = contractsById(contract_id);
        if (currentUser.getContracts().containsAll(contracts)||currentUser.getRole().equals(Role.ADMIN)) {
            List<Tariff> tariffs = tariffService.tariffsById(tariff_id);
            for (Tariff tariff : tariffs) {
                for (Contract contract : contracts) {
                    for (Option option : contract.getOptions()) {
                        option.getContracts().remove(contract);
                        optionService.updateEntity(option);
                    }
                    contract.getTariff().getContracts().remove(contract);
                    tariffService.updateEntity(contract.getTariff());
                    contract.getOptions().clear();
                    contract.setTariff(tariff);
                    updateEntity(contract);
                }
            }
        }
        TariffForStand tariffForStand = new TariffForStand(tariffService.getEntityById(tariff_id));
        sender.sendMessageToStand(tariffForStandOld);
        sender.sendMessageToStand(tariffForStand);
    }

    @Override
    public void setTariffAndOptionsFromCart(Cart cart, int contract_id) {
        List<Contract> contracts = contractsById(contract_id);
        if (cart.getTariff() != null) {
            for (Contract contract : contracts) {
                contract.getTariff().getContracts().remove(contract);
                tariffService.updateEntity(contract.getTariff());
                for (Option option : contract.getOptions()) {
                    option.getContracts().remove(contract);
                    optionService.updateEntity(option);
                }
                contract.getOptions().clear();
                contract.setTariff(cart.getTariff());
                contract.setOptions(cart.getOptions());
                updateEntity(contract);
                cart.setTariff(null);
                cart.getOptions().clear();
            }
        }
    }
}
