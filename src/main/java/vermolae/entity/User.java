package vermolae.entity;

import lombok.*;

import javax.persistence.*;

//@Entity
//@Table(name = "users")
//@NamedQuery(name = "User.getAll", query = "SELECT u FROM User u")
//@Getter
//@Setter
@Entity
@Table(name = "users")
@NamedQuery(name = "User.getAll", query = "SELECT u FROM User u")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname")
    @Basic
    private String firstname;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //    @Column(name = "lastname")
//    private String lastname;
//
//    @Column(name = "email")
//    private String email;
//
//    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "role")
    private Role role;

    //    @SequenceGenerator(name = "seq-gen", sequenceName = "hibernate_sequence", initialValue = 205, allocationSize = 12)
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq-gen")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public User(String firstname) {
       this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                '}';
    }
    public User() {
    }
}
