package vermolae.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "picture")
    private byte[] pictureBytes;


    public Picture(String name, byte[] pictureBytes) {
        this.name = name;
        this.pictureBytes = pictureBytes;

    }

    public Picture() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPictureBytes() {
        return pictureBytes;
    }

    public void setPictureBytes(byte[] pictureBytes) {
        this.pictureBytes = pictureBytes;
    }

    public Integer getId() {
        return id;
    }
}
