package vermolae.crud.service.api;

import vermolae.model.Cart.Cart;
import vermolae.model.entity.Contract;
import vermolae.model.entity.User;

import java.util.List;

public interface ContractService extends GenericService<Contract, Integer> {

    public String getRandomNumber();

    public void createNewDefaultContract(User user, String number);

    public List<Contract> contractsById(int id);

    public void addNewOption(int contract_id, int option_id);

    public void deleteOption(int contract_id, int option_id);

    public void setTariff(int contract_id, int tariff_id);

    public void setTariffAndOptionsFromCart(Cart cart, int contract_id);
}
