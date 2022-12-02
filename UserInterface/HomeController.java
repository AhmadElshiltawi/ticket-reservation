package UserInterface;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

    @FXML
    private Button logoutButton;

    @FXML
    void userLogout(ActionEvent event) throws IOException{
        LoginGUI m = new LoginGUI();
        m.changeScene("/fxml/logingui.fxml");
    }

}
