package Entry;

public class User {
    private String email;
    boolean isRegistered = false;

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
