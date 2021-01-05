package vermolae.crud.service.serviceApi;

import vermolae.entity.User;
import vermolae.exeptions.UserNotFoundException;

public interface UserService extends GenericService<User, Long> {

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
//    public User getUserByEMAil(String eMail) throws UserNotFoundException;

}
