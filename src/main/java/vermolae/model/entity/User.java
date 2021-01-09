package vermolae.model.entity;

import lombok.Data;
import vermolae.model.Role.Role;
import vermolae.model.Role.Status;

import javax.persistence.*;

//@Entity
//@Table(name = "users")
//@NamedQuery(name = "User.getAll", query = "SELECT u FROM User u")
//@Getter
//@Setter
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

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    @Basic
    private Status status;

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
}
