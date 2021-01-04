package vermolae.crud.service.serviceImpl;

import org.springframework.stereotype.Service;
import vermolae.crud.service.serviceApi.BaseService;
import vermolae.dao.daoImpl.UserDao;
import vermolae.entity.User;

@Service
public class UserService extends BaseService<UserDao, User> {

}
