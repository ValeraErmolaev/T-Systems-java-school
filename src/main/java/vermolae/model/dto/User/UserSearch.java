package vermolae.model.dto.User;

public class UserSearch {
    private String condition;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String email) {
        this.condition = email;
    }

    public UserSearch(String condition) {
        this.condition = condition;
    }

    public UserSearch() {
    }
}
