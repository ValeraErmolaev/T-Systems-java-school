package vermolae.crud.service.api;

import vermolae.model.entity.Contract;
import vermolae.model.entity.User;

public interface ContractService extends GenericService<Contract, Integer> {

        public String getRandomNumber();

        public void createNewDefaultContract(User user, String number);
}
