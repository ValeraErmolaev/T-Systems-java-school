package vermolae.model.entity;

import lombok.Data;
import vermolae.model.Enum.Role;
import vermolae.model.Enum.Status;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Data
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

    @Column(name = "lastname")
    @Basic
    private String lastname;

    @Column(name = "password")
    @Basic
    private String password;

//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "role")
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "email")
    @Basic
    private String email;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "address")
    private String address;

    @Column(name = "passport")
    private String passport;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    @Basic
    private Status status;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    private final List<Contract> contracts = new ArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
