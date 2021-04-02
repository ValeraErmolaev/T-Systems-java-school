package vermolae.crud.dao.impl;

import org.springframework.stereotype.Repository;
import vermolae.crud.dao.api.OptionDAO;
import vermolae.model.entity.Option;
@Repository("optionDAO")
public class OptionDAOImpl extends GenericDAOImpl<Option, Integer> implements OptionDAO {
}
