package vermolae.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "possible_options",
            joinColumns = @JoinColumn(name = "option_id"),
            inverseJoinColumns = @JoinColumn(name = "tariff_id")
    )
    private List<Tariff> tariffs = new ArrayList<>();

    public void addTariff(Tariff tariff){
        tariffs.add(tariff);
        tariff.getOptions().add(this);
    }

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

    public List<Tariff> getTariffs() {
        return tariffs;
    }

    public void setTariffs(List<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return Id == option.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
