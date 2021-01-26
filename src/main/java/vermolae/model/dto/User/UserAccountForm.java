package vermolae.model.dto.User;

import vermolae.model.Enum.Role;
import vermolae.model.Enum.Status;
import vermolae.model.entity.Contract;
import vermolae.model.entity.User;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public class UserAccountForm {

    private int id;

    private String fullname;

    private String email;

    private Date date;
    private String passport;

    private String address;

    private Set<Contract> contracts;

    private Status status;

    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String firstname) {
        this.fullname = firstname;
    }

    public Status getStatus() {
        return status;
    }

    public void setIsActive(Status status) {
        this.status = status;
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserAccountForm(User user) {
        this.id = user.getId();
        this.fullname = user.getLastname().concat(" ").concat(user.getFirstname());
        this.email = user.getEmail();
        this.status = user.getStatus();
        this.role = user.getRole();
        this.date = user.getBirthdate();
        this.passport = user.getPassport();
        this.contracts=user.getContracts();
        this.address = user.getAddress();
    }

    public UserAccountForm(UserRegistrationForm userRegForm) {

        this.fullname = userRegForm.getFirstname().concat(" ").concat(userRegForm.getLastname());
        this.email = userRegForm.getEmail();
        this.role = Role.USER;
        this.passport = userRegForm.getPassport();
        this.status = Status.ACTIVE;
        this.date = userRegForm.getDate();
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
