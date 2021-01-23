package vermolae.crud.service.api;

import org.springframework.web.multipart.MultipartFile;
import vermolae.model.entity.Picture;

import java.io.File;
import java.io.IOException;

public interface PictureService extends GenericService<Picture, Integer>{
    public void saveNewPicture(String name, MultipartFile file) throws IOException;

    public Picture getPictureByName(String name) throws Exception;
}
