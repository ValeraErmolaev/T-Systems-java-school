package vermolae.dao.daoImpl;

import javax.persistence.EntityManagerFactory;
import org.springframework.stereotype.Repository;
import vermolae.entity.User;

@Repository("UserDao")
public class UserDao extends Dao<User> {

    UserDao(EntityManagerFactory factory) {
        super(User.class,"User", factory.createEntityManager());
    }
}
