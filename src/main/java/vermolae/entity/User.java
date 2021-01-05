package vermolae.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.getAll", query = "SELECT u FROM User u")
@Getter
@Setter
public class User {


    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthdaydata")
    private String birthdaydata;

    @Column(name = "passport")
    private String passport;

    @SequenceGenerator(name = "seq-gen", sequenceName = "hibernate_sequence", initialValue = 205, allocationSize = 12)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq-gen")
    public Long getId() {
        return id;
    }

    @Column(name = "address")
    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "contract")
    private String contract;

//    @Transient
//    transient private String confirmPassword;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

        @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "role")
    private Role role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthdaydata='" + birthdaydata + '\'' +
                ", passport='" + passport + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
//                ", confirmPassword='" + confirmPassword + '\'' +
                ", role=" + role +
                '}';
    }

    public User(String firstname, String lastname, String patronymic, String birthdaydata, String passport, String address, String email, String password, String contract, Role role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.birthdaydata = birthdaydata;
        this.passport = passport;
        this.address = address;
        this.email = email;
        this.password = password;
        this.contract = contract;
        this.role = role;
    }
}
