package vermolae.dao.daoImpl;

import org.springframework.stereotype.Repository;
import vermolae.dao.dao_new.ContractDAO;
import vermolae.dao.dao_new.GenericDAOImpl;
import vermolae.entity.Contract;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
public class ContractDAOImpl extends GenericDAOImpl<Contract, Long> implements ContractDAO {
    @PersistenceContext
    private EntityManager entityManager;
}
