package vermolae.crud.service.api;

import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.model.entity.User;
import vermolae.exeptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface UserService extends GenericService<User, Integer> {

    /**
     * Getting user entity by number
     *
     * @param number entity for getting
     * @return user with adjusted number
     * @throws UserNotFoundException if user not found
     */
    public User getUserByNumber(String number) throws UserNotFoundException;

    /**
     * Getting user entity by email
     *
     * @param eMail entity for getting
     * @return user with adjusted email
     * @throws UserNotFoundException if user not found
     */
    public User getUserByEMAil(String eMail) throws UserNotFoundException;

    /**
     *
     * @param userDto
     * @return
     */
    public UserRegistrationForm registerUser(UserRegistrationForm userDto);

    /**
     *
     * @param login
     * @return
     */
    public User userByLogin(String login);

    /**
     *
     * @param emailOrNumber
     * @return
     */
   public ArrayList<User> userListByCond(String emailOrNumber);

    /**
     * list account form users (dto)
     * @param emailOrNumber
     * @return
     */
   public List<UserAccountForm> userAccListByCond(String emailOrNumber);

    /**
 * create new number and insert in user contracts
     */
   public void createAndAddNewContract(User user);

   public void blockContract(int user_id,int contract_id);

   public void unBlockContract(int user_id,int contract_id);

   public void changeUserStatus(int user_id);

   public void blockContractByAdmin(int id);

   public void unblockContractByAdmin(int id);

   public List<User> getAll();

   public Collection<User> usersByEmail(String email);
}
