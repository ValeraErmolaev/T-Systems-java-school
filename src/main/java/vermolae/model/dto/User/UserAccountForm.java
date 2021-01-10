package vermolae.model.dto.User;

import vermolae.model.Role.Role;
import vermolae.model.Role.Status;
import vermolae.model.entity.User;

public class UserAccountForm {

//    private int id;

    private String firstname;

    private String email;

    //TODO:
    //private Set<Contract> contracts

    private Status status;

    private Role role;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
//        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.email = user.getEmail();
        this.status = user.getStatus();
        this.role = user.getRole();
    }

    public UserAccountForm(UserRegistrationForm userRegForm) {
//        this.id = id;
        this.firstname = userRegForm.getFirstname();
        this.email = userRegForm.getEmail();
        this.role = Role.USER;
        this.status = Status.ACTIVE;
    }
}
