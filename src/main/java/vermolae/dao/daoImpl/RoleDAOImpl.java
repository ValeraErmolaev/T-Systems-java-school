package vermolae.dao.daoImpl;

import org.springframework.stereotype.Repository;
import vermolae.dao.dao_new.GenericDAOImpl;
import vermolae.dao.dao_new.RoleDAO;
import vermolae.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDAOImpl extends GenericDAOImpl<Role, Integer> implements RoleDAO {
    @PersistenceContext
    private EntityManager entityManager;
}