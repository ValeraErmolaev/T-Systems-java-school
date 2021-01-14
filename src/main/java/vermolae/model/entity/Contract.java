package vermolae.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "contracts")
//@NamedQuery(name = "Contract.getAll", query = "SELECT c FROM Contract c")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Basic
    @Column(name = "number")
    private String number;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


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


}
