package vermolae.crud.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vermolae.crud.dao.api.PictureDAO;
import vermolae.model.entity.Picture;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Repository("pictureDAO")
public class PictureDAOImpl extends GenericDAOImpl<Picture, Integer> implements PictureDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveNewPicture(Picture picture) {
        create(picture);
    }

    @Override
    public String urlPicture(int id) {
        return "";
    }

    @Override
    public Picture getPictureByName(String name) throws Exception {
        try {
            Query query = entityManager.createQuery("select p from Picture p where p.name=:name")
                    .setParameter("name", name);
            return (Picture) query.getSingleResult();
        } catch (PersistenceException ex) {
            throw new Exception();
        }
    }
}
