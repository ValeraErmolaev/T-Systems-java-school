package vermolae.crud.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vermolae.crud.dao.api.RoleDAO;
import vermolae.crud.dao.api.UserDAO;
import vermolae.crud.service.api.UserService;
//import vermolae.model.entity.Role;
import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.model.entity.User;
import vermolae.exeptions.CustomDAOException;
import vermolae.exeptions.UserNotFoundException;

import java.util.List;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Creating contract user in base
     *
     * @param user entity for creating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void createEntity(User user) throws CustomDAOException {
//        if (!isUserExists(user)) {

        user.setRole(roleDAO.getRoleByName("User"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //TODO passwordEncoder user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userDAO.create(user);

//        }
    }
    @Override
    @Transactional
    public UserRegistrationForm registerUser(UserRegistrationForm userDto) {
        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(roleDAO.getRoleByName("User"));
        userDAO.create(user);
        return userDto;

    }

    /**
     * Get user entity by id
     *
     * @param id id for getting
     * @return user with adjusted id
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public User getEntityById(Integer id) throws CustomDAOException {
        return userDAO.read(id);
    }

    /**
     * Update user entity in base
     *
     * @param entity entity for updating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Override
    @Transactional
    public User getUserByEMAil(String eMail) throws UserNotFoundException {
        return userDAO.getUserByEMAil(eMail);
    }



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
//    public void cahngeUserAccessLevel(User user, Role role) {
////        user.setRole(role);
//        updateEntity(user);
//    }

}