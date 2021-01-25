package vermolae.model.entity;

import javax.persistence.*;
import java.util.Objects;

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
    @JoinColumn(name="tariff_id")
    private Tariff tariff;


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
        this.tariff = tariff;
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
