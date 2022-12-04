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
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/gui.fxml"));
        primaryStage.setTitle("GUI");
        primaryStage.setScene(new Scene(root, 1050, 764));
        primaryStage.show();

    }
    

    public static void main(String[] args) { //this just runs the gui
        launch(args);
    }

}