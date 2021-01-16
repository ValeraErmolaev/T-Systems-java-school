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

    private List<Contract> contracts;

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
        this.fullname = user.getFirstname().concat(" ").concat(user.getLastname());
        this.email = user.getEmail();
        this.status = user.getStatus();
        this.role = user.getRole();
        this.contracts=user.getContracts();
    }

    public UserAccountForm(UserRegistrationForm userRegForm) {

        this.fullname = userRegForm.getFirstname().concat(" ").concat(userRegForm.getLastname());
        this.email = userRegForm.getEmail();
        this.role = Role.USER;
        this.status = Status.ACTIVE;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
