package Entry;

public class RegisteredUser extends User {
    private String username;
    private String password;

    public RegisteredUser(String username, String password, String email) {
        super(email);
        this.isRegistered = true;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void SetPassword(String password) {
        this.password = password;
    } 
}
