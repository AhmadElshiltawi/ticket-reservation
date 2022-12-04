package Entry;

public class RegisteredUser extends User {
    private String username;
    private String password;
    private String credit;

    public RegisteredUser(String username, String password, String email, String credit) {
        super(email);
        this.isRegistered = true;
        this.username = username;
        this.password = password;
        this.credit = credit;
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

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    } 
}
