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
    //ToDO send to service
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveNewPicture(Picture picture) throws Exception{
//        byte[] fileContent = FileUtils.readFileToByteArray(file);
        create(picture);
//        String encodedString = Base64.getEncoder().encodeToString(fileContent);
//        String url = "data:image/jpeg;base64,"+ encodedString;
    }
    //TODO delete this
    @Override
    @Transactional
    public String urlPicture(int id){
        Picture pic = read(id);
//        String encodedString = Base64.getEncoder().encodeToString(pic.getPicture());
//        String url = "data:image/jpeg;base64,"+ encodedString;
//        return url;
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
