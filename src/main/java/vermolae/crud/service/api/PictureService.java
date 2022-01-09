package vermolae.crud.service.api;

import org.springframework.web.multipart.MultipartFile;
import vermolae.model.entity.Picture;

import java.io.IOException;

public interface PictureService extends GenericService<Picture, Integer>{
     void saveNewPicture(String name, MultipartFile file) throws IOException;

     Picture getPictureByName(String name) throws Exception;
     Picture getDefaultPicture() throws  Exception;
}
