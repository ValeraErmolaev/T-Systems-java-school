package vermolae.model.entity;

import javax.persistence.*;

@Entity
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

    @Column(name = "turnOnPrice")
    @Basic
    private double turnOnPrice;

    //TODO !!!!!!!!!!!!!!!!!!!!!!!!!!
    @Column(name = "fieldForOptions")
    @Basic
    private double fieldForOptions;


}
