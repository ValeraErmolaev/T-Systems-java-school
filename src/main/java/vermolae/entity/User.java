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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname")
    @Basic
    private String firstname;

//    @Column(name = "lastname")
//    private String lastname;
//
//    @Column(name = "email")
//    private String email;
//
//    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
////    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "role")
//    private Role role;

//    @SequenceGenerator(name = "seq-gen", sequenceName = "hibernate_sequence", initialValue = 205, allocationSize = 12)
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq-gen")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", firstname='" + firstname + '\'' +
//                ", lastname='" + lastname + '\'' +
//                ", role=" + role +
//                '}';
//    }

//    public User(String firstname, String lastname, String email, Role role) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.email = email;
//        this.role = role;
//    }

    public User(Integer id, String firstname) {
        this.id = id;
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

    //
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
    public User() {
    }
}
