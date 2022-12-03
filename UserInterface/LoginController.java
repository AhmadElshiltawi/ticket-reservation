package UserInterface;

import java.io.IOException;
import java.sql.SQLException;

import Entry.User;
import Entry.UserEntrySingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private UserEntrySingleton userSingleton;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginbutton;

    @FXML
    private Label wrongLogInLabel;

    @FXML
    private Button signUpButton;

    @FXML
    private Button skipButton;

    @FXML
    private PasswordField newPassword;

    @FXML
    private TextField newEmail;

    @FXML
    private Label signUpSuccessfulLabel;

    @FXML
    void userLogin(ActionEvent event) throws IOException, SQLException {
        checkLogin();
    }

    private void checkLogin() throws IOException, SQLException {
        userSingleton = UserEntrySingleton.getInstance();
        User user = userSingleton.validateAccount(username.getText().toString(), password.getText().toString());
        LoginGUI m = new LoginGUI();

        if (user == null) {
            if (username.getText().isEmpty() && password.getText().isEmpty()) {
                wrongLogInLabel.setText("Please enter your username and password");
            }
            else {
                wrongLogInLabel.setText("Wrong username or password.");
            }
        }
        else {
            wrongLogInLabel.setText("You have successfully logged in.");
            m.changeScene("/fxml/homegui.fxml");
        }
    }

    @FXML
    void continueUnregistered(ActionEvent event) throws IOException {
        LoginGUI m = new LoginGUI();
        m.changeScene("/fxml/homeguiguest.fxml");
    }

    @FXML
    void signUp(ActionEvent event) throws SQLException {
        checkSignUpValidity();
    }

    private void checkSignUpValidity() throws SQLException {
        userSingleton = UserEntrySingleton.getInstance();
        LoginGUI m = new LoginGUI();
        
        if (newEmail.getText().isEmpty() && newPassword.getText().isEmpty()) {
            wrongLogInLabel.setText("Please enter your email and password");
        }
        else {
            User newUser = userSingleton.addRegisteredUser("SigmaMindset", newPassword.getText(), newEmail.getText());
            if (newUser == null) {
                wrongLogInLabel.setText("An error occurred! Please check your email and password");
            }
            else {
                wrongLogInLabel.setText("Username registered!");
            }
        }
    
        // if newEmail.getText().toString() is VALID (check against regex) 
        // and newPassword.getText().toString() is VALID (check against whatever checks u need)
        // add new user to database
        //signUpSuccessfulLabel.setText("Successfully created an account, you may log in now.")
        // else
        // do not add new user to database
        // signUpSuccessfulLabel.setText("Something went wrong, please try signing up again.")
    }
}