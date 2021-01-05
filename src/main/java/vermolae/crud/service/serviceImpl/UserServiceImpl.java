package vermolae.crud.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import vermolae.crud.service.serviceApi.UserService;
import vermolae.dao.dao_new.UserDAO;
import vermolae.entity.Role;
import vermolae.entity.User;
import vermolae.exeptions.CustomDAOException;
import vermolae.exeptions.UserNotFoundException;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    /**
     * Creating contract user in base
     *
     * @param user entity for creating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
//    @Transactional
    public void createEntity(User user) throws CustomDAOException {
//        if (!isUserExists(user)) {
            userDAO.create(user);
//        }
    }

    /**
     * Get user entity by id
     *
     * @param id id for getting
     * @return user with adjusted id
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
//    @Transactional
    public User getEntityById(Long id) throws CustomDAOException {
        return userDAO.read(id);
    }

    /**
     * Update user entity in base
     *
     * @param entity entity for updating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
//    @Transactional
    public void updateEntity(User entity) throws CustomDAOException {
        userDAO.update(entity);
    }

    /**
     * Delete user entity from base
     *
     * @param entity entity for deleting
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
//    @Transactional
    public void deleteEntity(User entity) throws CustomDAOException {
        userDAO.delete(entity);
    }

    /**
     * Getting all user entities from base
     *
     * @return list of all users
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
//    @Transactional
    public List<User> getAll() throws CustomDAOException {
        return userDAO.getAll();

    }

    /**
     * Getting user entity by number
     *
     * @param number entity for getting
     * @return user with adjusted number
     * @throws UserNotFoundException if user not found
     */
    @Override
//    @Transactional
    public User getUserByNumber(String number) throws UserNotFoundException {
        return userDAO.getUserByNumber(number);
    }

    /**
     * Getting user entity by email
     *
     * @param eMail entity for getting
     * @return user with adjusted email
     * @throws UserNotFoundException if user not found
     */
//    @Override
//    @Transactional
//    public User getUserByEMAil(String eMail) throws UserNotFoundException {
//        return userDAO.getUserByEMAil(eMail);
//    }

    /**
     * Checking user existing in base
     *
     * @param user entity for checking
     * @return true - if user exists, false if doesn't
     */
//    public boolean isUserExists(User user) {
//        try {
//            return getUserByEMAil(user.getEmail()) != null ? true : false;
//        } catch (UserNotFoundException ex) {
//            logger.error(ex);
//            return false;
//        }
//    }

    /**
     * Changing user's access level in base
     *
     * @param user        entity for changing level
     * @param role new level
     */
//    public void cahngeUserAccessLevel(User user, AccessLevel accessLevel) {
//        user.setAccessLevel(accessLevel);
//        updateEntity(user);
//    }
    public void cahngeUserAccessLevel(User user, Role role) {
        user.setRole(role);
        updateEntity(user);
    }

}
