package vermolae.crud.dao.impl;

import org.springframework.stereotype.Repository;
import vermolae.crud.dao.api.RoleDAO;
import vermolae.entity.Role;
import vermolae.entity.User;
import vermolae.exeptions.CustomDAOException;
import vermolae.exeptions.RoleNotFoundException;
import vermolae.exeptions.UserNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Repository("roleDAO")
public class RoleDAOImpl extends GenericDAOImpl<Role, Integer> implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleByName(String role_name) throws RoleNotFoundException {
        try {
            Query query = entityManager.createQuery("select r from Role r where r.role_name=:role_name")
                    .setParameter("role_name", role_name);
            return (Role) query.getSingleResult();
        } catch (PersistenceException ex) {
            throw new UserNotFoundException("Role with role_name " + role_name + " not found!", ex);
        }
    }
    @Override
    public void create(Role entity) throws CustomDAOException {

    }

    @Override
    public void update(Role entity) throws CustomDAOException {

    }

    @Override
    public void delete(Role entity) throws CustomDAOException {

    }
}
