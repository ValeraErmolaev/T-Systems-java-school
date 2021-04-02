package vermolae.crud.dao.impl;

import org.springframework.stereotype.Repository;
import vermolae.crud.dao.api.ContractDAO;
import vermolae.model.entity.Contract;
@Repository("contractDAO")
public class ContractDAOImpl extends GenericDAOImpl<Contract, Integer> implements ContractDAO {

}
