package UserInterface;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LoginController {

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
    void userLogin(ActionEvent event) throws IOException {

        checkLogin();
    }

    private void checkLogin() throws IOException { //this is the function that checks the login to see if it is valid.
        LoginGUI m = new LoginGUI();
        if (username.getText().toString().equals("orionahn") && password.getText().toString().equals("123")) {
            wrongLogInLabel.setText("You have successfully logged in.");
            m.changeScene("/fxml/homegui.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogInLabel.setTextFill(Color.GREEN);
            wrongLogInLabel.setText("Please enter your username and password");
            
        } else {
            wrongLogInLabel.setText("Wrong username or password.");
        }
    }

    @FXML
    void continueUnregistered(ActionEvent event) throws IOException {
        LoginGUI m = new LoginGUI();
        m.changeScene("/fxml/homeguiguest.fxml");
    }

    @FXML
    void signUp(ActionEvent event) {
        checkSignUpValidity();
    }

    private void checkSignUpValidity(){
    LoginGUI m = new LoginGUI();

    
    
    }

}
