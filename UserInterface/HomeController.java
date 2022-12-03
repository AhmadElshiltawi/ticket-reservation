
package UserInterface;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HomeController {

    public String username;

    @FXML
    private Button btnMenus;

    @FXML
    private ImageView amogus;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Label userLoggedInShow;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private VBox pnItems;

    @FXML
    private VBox pnItems1;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlMenus;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    void handleClicks(ActionEvent event) {
    }

    @FXML
    void userLogout(ActionEvent event) throws IOException {
        LoginGUI m = new LoginGUI();
        m.changeScene("/fxml/logingui.fxml");
    }

}
