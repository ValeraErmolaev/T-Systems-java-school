package vermolae.model.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@NamedQuery(name = "Tariff.getAll", query = "SELECT t FROM Tariff t")
@Table(name = "tariffs")
public class Tariff {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Basic
    private String name;

    @Column(name = "description")
    @Basic
    private String description;

    @Column(name = "price")
    @Basic
    private double price;

    @Column(name = "turnonprice")
    @Basic
    private double turnonprice;

    //TODO !!!!!!!!!!!!!!!!!!!!!!!!!!
//    @Column(name = "fieldForOptions")
//    @Basic
//    private double fieldForOptions;


    public Tariff() {
    }

    public Tariff( String name, String description, double price, double turnonprice) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.turnonprice = turnonprice;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double turnonprice() {
        return turnonprice;
    }

    public void turnonprice(double turnOnPrice) {
        this.turnonprice = turnOnPrice;
    }
}
