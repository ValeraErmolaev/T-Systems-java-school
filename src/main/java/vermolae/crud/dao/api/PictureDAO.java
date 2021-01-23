package vermolae.crud.dao.api;

import vermolae.model.entity.Picture;

import java.io.File;

public interface PictureDAO extends GenericDAO<Picture, Integer>{

    void saveNewPicture(Picture picture) throws Exception;


    public String urlPicture(int id);

    public Picture getPictureByName(String name) throws Exception;
}
