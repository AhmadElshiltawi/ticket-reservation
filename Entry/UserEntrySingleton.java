package Entry;
import java.util.*;
import java.util.regex.Pattern;

public class UserEntrySingleton {
    private static UserEntrySingleton instance = null;
    private List<User> users = new ArrayList<>();
    
    private static final String EMAIL_REGEX = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";
    private Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    // instagram username regex
    private static final String USERNAME_REGEX = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
    private Pattern usernamePattern = Pattern.compile(USERNAME_REGEX);

    private static final String PASSWORD_REGEX = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!<>@$%^&*-]).{8,}$";
    private Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);

    private UserEntrySingleton() {}

    public static UserEntrySingleton getInstance()
    {
        if (instance == null)
            instance = new UserEntrySingleton();
  
        return instance;
    }

    public void addRegisteredUser(String username, String password, String email) {
        if (checkEmailExistance(email) && checkUsernameExistance(username)) {
            if (!validateEmail(email)) {
                System.out.println("Email " + email + " is not valid!");
                return;
            }

            if (!validateUsername(username)) {
                System.out.println("Username " + username + " is not valid!");
                return;
            }

            if (!validatePassword(password)) {
                System.out.println("Your password is not valid!");
                System.out.println("Password criteria:");
                System.out.println("- Minimum eight letters");
                System.out.println("- At least one uppercase letter");
                System.out.println("- At least one lowercase letter");
                System.out.println("- At least one special character");
                System.out.println("- At least one digit\n");
                return;
            }

            users.add(new RegisteredUser(username, password, email));
            System.out.println("Added " + username + "! array size: " + users.size());
        }
    }

    private boolean validateEmail(String email) {
        return emailPattern.matcher(email).matches();
    }

    private boolean validateUsername(String username) {
        return usernamePattern.matcher(username).matches();
    }

    private boolean validatePassword(String password) {
        return passwordPattern.matcher(password).matches();
    }

    public void addOrdinaryUser(String email) {
        if (checkEmailExistance(email)) {
            if (!validateEmail(email)) {
                System.out.println("Email " + email + " is not valid!");
                return;
            }
            users.add(new User(email));
            System.out.println("Added " + email + "! array size: " + users.size());
        }
    }

    private boolean checkUsernameExistance(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof RegisteredUser) {
                RegisteredUser currentUser = (RegisteredUser) users.get(i);
                if (currentUser.getUsername() == username) {
                    System.out.println("Username (" + username + ") already exists!");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkEmailExistance(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail() == email) {
                System.out.println("Email (" + email + ") already exists!");
                return false;
            }
        }
        return true;
    }

    public boolean validateAccount(String authenticator, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof RegisteredUser) {
                RegisteredUser currentUser = (RegisteredUser) users.get(i);
                
                if (currentUser.getUsername() == authenticator) {
                    if (currentUser.getPassword() == password) {
                        System.out.println("Account validated!");
                        return true;
                    }
                    else {
                        System.out.println("The incorrect password was inputted!");
                        return false;
                    }
                }

                if (currentUser.getEmail() == authenticator) {
                    if (currentUser.getPassword() == password) {
                        System.out.println("Account validated!");
                        return true;
                    }
                    else {
                        System.out.println("The incorrect password was inputted!");
                        return false;
                    }
                }
            }
        }
        System.out.println("No account was found that matched (" + authenticator + ").");
        return false;
    }

    public void deleteUser(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail() == email) {
                users.remove(i);
                System.out.println("User deleted! Array size: " + users.size());
            }
        }
    }

    public void RegisterOrdinaryUser(String username, String password, String email) {
        deleteUser(email);
        addRegisteredUser(username, password, email);
    }
}
