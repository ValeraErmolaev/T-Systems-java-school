package vermolae.crud.service.api;

import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.model.entity.User;
import vermolae.exeptions.UserNotFoundException;

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
}
