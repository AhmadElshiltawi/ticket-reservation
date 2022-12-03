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
import javafx.scene.paint.Color;

public class LoginController {
    private UserEntrySingleton userSingleton;
    private User loggedInUser = null;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginbutton;

    
    @FXML
    private Label statusLabel;

    @FXML
    private Button signUpButton;

    @FXML
    private Button skipButton;

    @FXML
    private PasswordField newPassword;


    @FXML
    private Label signUpSuccessfulLabel;

    @FXML
    private TextField newEmail;

    @FXML
    private TextField newUsername;

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
                signUpSuccessfulLabel.setText("Please enter your username and password");
            }
            else {
                signUpSuccessfulLabel.setText("Wrong username or password.");
            }
        }
        else {
            loggedInUser = user;
            signUpSuccessfulLabel.setText("Logging in...");
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
            signUpSuccessfulLabel.setText("Please enter your email and password");
        }
        else {
            User newUser = userSingleton.addRegisteredUser(newUsername.getText(), newPassword.getText(), newEmail.getText());
            if (newUser == null) {
                signUpSuccessfulLabel.setText("An error occurred! Please check your email and password");
            }
            else {
                signUpSuccessfulLabel.setText("Username registered!");
            }
        }
    }
}