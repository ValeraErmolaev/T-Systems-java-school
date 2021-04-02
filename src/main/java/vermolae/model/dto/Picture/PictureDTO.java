package vermolae.model.dto.Picture;

import vermolae.model.entity.Picture;

import java.io.File;

public class PictureDTO {

    private String name;
    private String path;
    private File file;
    private byte[] pictureBytes;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public byte[] getPictureBytes() {
        return pictureBytes;
    }

    public void setPictureBytes(byte[] pictureBytes) {
        this.pictureBytes = pictureBytes;
    }

    public PictureDTO() {

    }

    public PictureDTO(Picture picture) {
        this.name = picture.getName();
        this.pictureBytes = picture.getPictureBytes();
    }
}
