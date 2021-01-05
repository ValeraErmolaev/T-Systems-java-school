package vermolae.crud.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vermolae.crud.service.serviceApi.RoleService;
import vermolae.dao.dao_new.RoleDAO;
import vermolae.entity.Role;
import vermolae.exeptions.CustomDAOException;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    /**
     * Creating accessLevel entity in base
     *
     * @param role entity for creating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
//    @Transactional
    public void createEntity(Role role) throws CustomDAOException {
        roleDAO.create(role);
    }

      /**
     * Getting accessLevel entity by id
     *
     * @param id id for getting
     * @return level with adjusted id
     * @throws CustomDAOException if connect with DAO goes wrong
     */

    @Override
//    @Transactional
    public Role getEntityById(Integer id) throws CustomDAOException {
        return roleDAO.read(id);
    }

    /**
     * Updating accessLevel entity in base
     *
     * @param role entity for updating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
//    @Transactional
    public void updateEntity(Role role) throws CustomDAOException {
        roleDAO.update(role);
    }

    /**
     * Deleting accessLevel entity from base
     *
     * @param role entity for deleting
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
//    @Transactional
    public void deleteEntity(Role role) throws CustomDAOException {
        roleDAO.delete(role);

    }

    /**
     * Getting list of access levels entities
     *
     * @return list of all levels
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
//    @Transactional
    public List<Role> getAll() throws CustomDAOException {
        return roleDAO.getAll();
    }

}
