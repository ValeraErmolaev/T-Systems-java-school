package vermolae.crud.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import vermolae.crud.dao.api.PictureDAO;
import vermolae.crud.service.api.PictureService;
import vermolae.exeptions.CustomDAOException;
import vermolae.model.entity.Picture;

import java.io.IOException;
import java.util.List;

@Service("pictureService")
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {

    private final PictureDAO pictureDAO;

    @Override
    @Transactional
    public void saveNewPicture(String name, MultipartFile file) throws IOException {

        try {
            Picture picture = pictureDAO.getPictureByName(name);
            picture.setPictureBytes(file.getBytes());
            pictureDAO.update(picture);
        } catch (Exception e) {
            Picture picture = new Picture();
            picture.setName(name);
            picture.setPictureBytes(file.getBytes());
            pictureDAO.create(picture);
        }
    }

    @Override
    @Transactional
    public Picture getPictureByName(String name) throws Exception {
        return pictureDAO.getPictureByName(name);
    }

    @Override
    @Transactional
    public Picture getDefaultPicture() throws Exception {
        return getPictureByName("default.jpeg");
    }

    @Override
    @Transactional
    public void createEntity(Picture entity) throws CustomDAOException {
        pictureDAO.create(entity);
    }

    @Override
    public Picture getEntityById(Integer id) throws CustomDAOException {
        return null;
    }

    @Override
    public void updateEntity(Picture entity) throws CustomDAOException {

    }

    @Override
    @Transactional
    public void deleteEntity(Picture entity) throws CustomDAOException {
        pictureDAO.delete(entity);
    }

    @Override
    public List<Picture> getAll() throws CustomDAOException {
        return null;
    }
}
