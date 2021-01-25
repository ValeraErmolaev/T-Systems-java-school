package vermolae.crud.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vermolae.crud.dao.api.RoleDAO;
import vermolae.crud.dao.api.UserDAO;
import vermolae.crud.service.api.ContractService;
import vermolae.crud.service.api.UserService;
import vermolae.model.Enum.Role;
import vermolae.model.Enum.Status;
import vermolae.model.dto.User.UserAccountForm;
import vermolae.model.dto.User.UserRegistrationForm;
import vermolae.model.entity.Contract;
import vermolae.model.entity.User;
import vermolae.exeptions.CustomDAOException;
import vermolae.exeptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ContractService contractService;

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

        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVE);
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
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setBirthdate(userDto.getDate());
        user.setAddress(userDto.getAddress());
        user.setPassport(userDto.getPassport());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        if (userDto.getRole() == null) {
            user.setRole(Role.USER);
        } else {
            user.setRole(userDto.getRole());
        }
        user.setStatus(Status.ACTIVE);
        userDAO.create(user);
        return userDto;

    }

    @Override
    @Transactional
    public User userByLogin(String login) {
        return userDAO.getUserByLogin(login);
    }

    @Override
    @Transactional
    public ArrayList<User> userListByCond(String emailOrNumber) {
        if (emailOrNumber == "") {
            return (ArrayList<User>) userDAO.getAll();
        }
        ArrayList<User> users = new ArrayList<>();
        try {
            users.add(userByLogin(emailOrNumber));
        } catch (Exception e) {
            return users;
        }
        return users;
    }

    @Override
    @Transactional
    public ArrayList<UserAccountForm> userAccListByCond(String cond) {
        ArrayList<UserAccountForm> usersDTO = new ArrayList<>();
        if (cond.equals("")) {
            List<User> users = userDAO.getAll();
            for (User user : users) {
                usersDTO.add(new UserAccountForm(user));
            }
        } else {
            List<User> users = userListByCond(cond);
            for (User user : users) {
                usersDTO.add(new UserAccountForm(user));
            }
        }

        return usersDTO;
    }

    /**
     * create new number and add it to user
     */
    @Override
    @Transactional
    public void createAndAddNewContract(User user) {
        String number = contractService.getRandomNumber();
        contractService.createNewDefaultContract(user, number);


    }

    @Override
    @Transactional
    public void blockContract(int user_id, int contract_id) {
        User user = getEntityById(user_id);
        Contract contract = contractService.getEntityById(contract_id);
        if (user.getContracts().contains(contract)) {
            contract.setIs_blocked(true);
            contractService.updateEntity(contract);
        }
    }

    @Override
    @Transactional
    public void unBlockContract(int user_id, int contract_id) {
        User user = getEntityById(user_id);
        Contract contract = contractService.getEntityById(contract_id);
        if (user.getContracts().contains(contract)) {
            contract.setIs_blocked(false);
            contractService.updateEntity(contract);
        }
    }

    @Override
    @Transactional
    public void changeUserStatus(int user_id) {
        User user = getEntityById(user_id);
        Status currentStatus = user.getStatus();
        if (currentStatus == Status.BANNED) {
            user.setStatus(Status.ACTIVE);
        } else {
            user.setStatus(Status.BANNED);
        }
        updateEntity(user);
    }

    @Override
    @Transactional
    public void blockContractByAdmin(int id) {
        Contract contract = contractService.getEntityById(id);
        contract.setIs_blocked(true);
        contract.setIs_blocked_by_admin(true);
        contractService.updateEntity(contract);
    }

    @Override
    @Transactional
    public void unblockContractByAdmin(int id) {
        Contract contract = contractService.getEntityById(id);
        contract.setIs_blocked_by_admin(false);
        contractService.updateEntity(contract);
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