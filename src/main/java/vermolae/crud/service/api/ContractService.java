package vermolae.crud.service.api;

import vermolae.model.Cart.Cart;
import vermolae.model.entity.Contract;
import vermolae.model.entity.User;

import java.util.List;

public interface ContractService extends GenericService<Contract, Integer> {

    String getRandomNumber();

    void createNewDefaultContract(User user, String number);

    List<Contract> contractsById(int id);

    void addNewOption(int contract_id, int option_id);

    void deleteOption(int contract_id, int option_id);

    void setTariff(int contract_id, int tariff_id);

    void setTariffAndOptionsFromCart(Cart cart, int contract_id);
}
