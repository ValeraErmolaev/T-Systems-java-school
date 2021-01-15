package vermolae.crud.dao.impl;

import org.springframework.stereotype.Repository;
import vermolae.crud.dao.api.TariffDAO;
import vermolae.model.entity.Tariff;

@Repository("tariffAO")
public class TariffDAOImpl extends GenericDAOImpl<Tariff, Integer> implements TariffDAO {

}
