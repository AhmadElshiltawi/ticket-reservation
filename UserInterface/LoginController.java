package UserInterface;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    public TextField username;

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
    void userLogin(ActionEvent event) throws IOException {

        checkLogin();
    }

    private void checkLogin() throws IOException {
        LoginGUI m = new LoginGUI();
        if (username.getText().toString().equals("orionahn") && password.getText().toString().equals("123")) {
            wrongLogInLabel.setText("You have successfully logged in.");
            m.changeScene("/fxml/homegui.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
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

    }

}
