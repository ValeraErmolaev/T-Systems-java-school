package vermolae.crud.dao.api;

import vermolae.model.entity.Picture;

public interface PictureDAO extends GenericDAO<Picture, Integer> {

    void saveNewPicture(Picture picture) throws Exception;

    String urlPicture(int id);

    Picture getPictureByName(String name) throws Exception;
}
