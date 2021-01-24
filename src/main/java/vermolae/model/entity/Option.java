package vermolae.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "options")
@NamedQuery(name = "Option.getAll", query = "SELECT o FROM Option o")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "connect_price")
    private double connectPrice;

    @Column(name = "price")
    private double price;

    public Option() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getConnectPrice() {
        return connectPrice;
    }

    public void setConnectPrice(double connectPrice) {
        this.connectPrice = connectPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
