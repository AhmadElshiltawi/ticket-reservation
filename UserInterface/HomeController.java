
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

    @FXML
    private AnchorPane mainPane;
    @FXML
    private ImageView amogus;
    @FXML
    private Label userLoggedInShow;
    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane userPanel;
    @FXML
    private Pane showtimePanel;
    @FXML
    private Pane ticketPanel;
    @FXML
    private Pane us;
    @FXML
    private Pane pnlOverview;
    @FXML
    private VBox pnItems;
    @FXML
    private VBox pnItems1;
    @FXML
    void changePanelHome(ActionEvent event) {
        pnlOverview.toFront();
    }
    @FXML
    void changePanelSearchMovies(ActionEvent event) {
        showtimePanel.toFront();
    }
    @FXML
    void changePanelTickets(ActionEvent event) {
        ticketPanel.toFront();
        ticketHandlerGUI();
    }
    @FXML
    void changePanelUserInfo(ActionEvent event) {
        userPanel.toFront();
    }
    @FXML
    void userLogout(ActionEvent event) throws IOException {
        LoginGUI m = new LoginGUI();
        m.changeScene("/fxml/logingui.fxml");
    }

    public void ticketHandlerGUI(){
        //In this code we need to retrieve ticket info
        // and output them
        // while enabling deletion as well


        //pseudocode

        
    }

}



