package UserInterface;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginGUI extends Application {

    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception { //This function starts the GUI for the login page
        stg = primaryStage;
        primaryStage.setResizable(true);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/logingui.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }

    public void changeScene(String fxml) throws IOException {  //this function changes the scene to the next one from the login page
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        Parent pane2 = FXMLLoader.load(getClass().getResource(fxml));
        if (fxml == "/fxml/logingui.fxml") {
            stg.setScene(new Scene(pane, 600, 400));
        } else {
            stg.setScene(new Scene(pane2, 1050, 764));
        }

        // stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) { //this just runs the gui
        launch(args);
    }

}
