package vermolae.model.dto.User;

public class UserSearch {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserSearch(String email) {
        this.email = email;
    }

    public UserSearch() {
    }
}
