package vermolae.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

@Entity
@Table(name = "roles")
@NamedQuery(name = "Role.getAll", query = "SELECT r FROM Role r")
@Setter
@Getter
public class Role {
    public Role() {

    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

    //    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy=GenerationType.AUTO)
////    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role")
    private String role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
    private Set<User> users;

    @SequenceGenerator(name = "seq-gen", sequenceName = "hibernate_sequence", initialValue = 205, allocationSize = 12)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq-gen")
    public Integer getId() {
        return id;
    }

    public Role(String role) {

        this.role = role;

    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }


}
