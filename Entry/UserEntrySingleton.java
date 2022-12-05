package Entry;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Pattern;

import Database.Database;

public class UserEntrySingleton {
    private static UserEntrySingleton instance = null;
    private List<User> users = new ArrayList<>(); // Local user arraylist
    static Database db;
    
    private static final String EMAIL_REGEX = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";
    private static Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    // instagram username regex
    private static final String USERNAME_REGEX = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
    private Pattern usernamePattern = Pattern.compile(USERNAME_REGEX);

    private static final String PASSWORD_REGEX = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!<>@$%^&*-]).{8,}$";
    private Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);

    private UserEntrySingleton() throws SQLException {
        db = Database.getInstance();
        db.populateUserArray(users); // populate the arraylist from the database
    }

    public static UserEntrySingleton getInstance() throws SQLException {
        if (instance == null) {
            instance = new UserEntrySingleton();
        }

        return instance;
    }

    public User addRegisteredUser(String username, String password, String email, String credit) throws SQLException {
        if (db.checkIfEmailExists(email) == false && db.checkIfUsernameExists(username) == false) {
            if (!validateEmail(email)) {
                System.out.println("Email " + email + " is not valid!");
                return null;
            }

            if (!validateUsername(username)) {
                System.out.println("Username " + username + " is not valid!");
                return null;
            }

            if (!validatePassword(password)) {
                System.out.println("Your password is not valid!");
                System.out.println("Password criteria:");
                System.out.println("- Minimum eight letters");
                System.out.println("- At least one uppercase letter");
                System.out.println("- At least one lowercase letter");
                System.out.println("- At least one special character");
                System.out.println("- At least one digit\n");
                return null;
            }

            User newUser = new RegisteredUser(username, password, email, credit);
            users.add(newUser);
            db.addUserToDatabase(username, password, email, true, credit);
            return newUser;
        }
        return null;
    }

    public static boolean validateEmail(String email) {
        return emailPattern.matcher(email).matches();
    }

    private boolean validateUsername(String username) {
        return usernamePattern.matcher(username).matches();
    }

    private boolean validatePassword(String password) {
        return passwordPattern.matcher(password).matches();
    }

    public void addOrdinaryUser(String email) throws SQLException {
        if (!db.checkIfEmailExists(email)) {
            if (!validateEmail(email)) {
                return;
            }
            // TODO: Not add stuff to database tbh
            //db.addUserToDatabase("", "", email, false);
            users.add(new User(email));
        }
    }

    public User validateAccount(String authenticator, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof RegisteredUser) {
                RegisteredUser currentUser = (RegisteredUser) users.get(i);
            
                if (currentUser.getEmail().equals(authenticator) && currentUser.getPassword().equals(password)) {
                    return currentUser;
                }

                if (currentUser.getUsername().equals(authenticator) && currentUser.getPassword().equals(password)) {
                    return currentUser;
                }
            }
        }
        return null;
    }

    public void deleteUser(String email) throws SQLException {
        db.deleteUserFromDatabase(email);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail() == email) {
                users.remove(i);
            }
        }
    }

    public void RegisterOrdinaryUser(String username, String password, String email, String credit) throws SQLException {
        deleteUser(email);
        addRegisteredUser(username, password, email, credit);
    }

    public int getUserCount() {
        return users.size();
    }

    public boolean isUserRegistered(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof RegisteredUser) {
                RegisteredUser currentUser = (RegisteredUser) users.get(i);
                if (email.equals(currentUser.getEmail())) {
                     return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception{
        UserEntrySingleton singleton = UserEntrySingleton.getInstance();
        boolean  t = singleton.isUserRegistered("ahmad@email.com");
        System.out.println(t);
        
    }
}
