package vermolae.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

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

    @Column(name = "is_deprecated")
    private boolean deprecated;

    @OneToOne
    @JoinColumn(name="picture_id")
    private Picture picture;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tariff")
    @JsonIgnore
    private Set<Contract> contracts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "possible_options",
            joinColumns = @JoinColumn(name = "tariff_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private Set<Option> options = new HashSet<>();

    public void addOption(Option option){
        options.add(option);
        option.getTariffs().add(this);
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

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

    public int getId() {
        return id;
    }

    public double getTurnonprice() {
        return turnonprice;
    }

    public void setTurnonprice(double turnonprice) {
        this.turnonprice = turnonprice;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public boolean isDeprecated() {
        return deprecated;
    }

    public void setDeprecated(boolean deprecated) {
        this.deprecated = deprecated;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return id == tariff.id &&
                Objects.equals(name, tariff.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
