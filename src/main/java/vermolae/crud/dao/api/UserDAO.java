package vermolae.crud.dao.api;

import vermolae.model.entity.User;
import vermolae.exeptions.UserNotFoundException;

public interface UserDAO extends GenericDAO<User, Integer> {

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
     * @return user with adjusted number
     * @throws UserNotFoundException if user not found
     */
    public User getUserByEMAil(String eMail) throws UserNotFoundException;

    /**
     * Getting user by login
     * @param login
     * @return
     * @throws UserNotFoundException
     */
    public User getUserByLogin(String login) throws UserNotFoundException;
}
