package UserInterface;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HomeGuestController extends HomeController {

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlMenus;

    @FXML
    private Pane pnlOverview;

    @FXML
    private VBox pnItems;

    HomeController controller = new HomeController();

    @FXML
    void handleClicks(ActionEvent event) {
    }

    @FXML
    void userLogout(ActionEvent event) throws IOException {
        controller.userLogout(event);
    }

}
