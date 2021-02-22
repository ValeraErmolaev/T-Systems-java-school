package vermolae.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "contracts")
@NamedQuery(name = "Contract.getAll", query = "SELECT c FROM Contract c")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Basic
    @Column(name = "number")
    private String number;

    @Basic
    @Column(name = "is_blocked")
    private boolean is_blocked;

    @Basic
    @Column(name = "is_blocked_by_admin")
    private boolean is_blocked_by_admin;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tariff_id", nullable = false)
    private Tariff tariff;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "selected_options",
            joinColumns = @JoinColumn(name = "contractid"),
            inverseJoinColumns = @JoinColumn(name = "optionid")
    )
    private Set<Option> options = new HashSet<>();

    public void addOption(Option option) {
        options.add(option);
        option.getContracts().add(this);
    }

    public Contract() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        if (getTariff() != null) {
            getTariff().getContracts().remove(this);
        }
        this.tariff = tariff;
        tariff.getContracts().add(this);
    }

    public boolean isIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(boolean is_blocked) {
        this.is_blocked = is_blocked;
    }

    public boolean isIs_blocked_by_admin() {
        return is_blocked_by_admin;
    }

    public void setIs_blocked_by_admin(boolean is_blocked_by_admin) {
        this.is_blocked_by_admin = is_blocked_by_admin;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        for (Option option : options) {
            option.getContracts().add(this);
        }
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Id == contract.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
