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
    User getUserByNumber(String number) throws UserNotFoundException;

    /**
     * Getting user entity by email
     *
     * @param eMail entity for getting
     * @return user with adjusted email
     * @throws UserNotFoundException if user not found
     */
    User getUserByEMAil(String eMail) throws UserNotFoundException;

    /**
     * @param userDto
     * @return
     */
    UserRegistrationForm registerUser(UserRegistrationForm userDto);

    /**
     * @param login
     * @return
     */
    User userByLogin(String login);

    /**
     * @param emailOrNumber
     * @return
     */
    ArrayList<User> userListByCond(String emailOrNumber);

    /**
     * list account form users (dto)
     *
     * @param emailOrNumber
     * @return
     */
    List<UserAccountForm> userAccListByCond(String emailOrNumber);

    /**
     * create new number and insert in user contracts
     */
    void createAndAddNewContract(User user);

    void blockContract(int user_id, int contract_id);

    void unBlockContract(int user_id, int contract_id);

    void changeUserStatus(int user_id);

    void blockContractByAdmin(int id);

    void unblockContractByAdmin(int id);

    List<User> getAll();

    Collection<User> usersByEmail(String email);

    String pageDependsOfRole(User user);

    List<UserAccountForm> getUsersById(int id);
}
