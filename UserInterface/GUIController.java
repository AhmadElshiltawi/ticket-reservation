package UserInterface;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import Entry.*;
import Theatre.*;
import Project.*;
import Payment.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GUIController {

    
    private UserEntrySingleton userSingleton;

    private User loggedInUser = null;
    @FXML
    private AnchorPane registeredUserHome;

    @FXML
    private PasswordField newCreditCard;

    @FXML
    private Label userLoggedInShowField;

    @FXML
    private Button homeBtn;

    @FXML
    private Button ticketBtn;

    @FXML
    private Button showtimeBtn;

    @FXML
    private Button userInfoBtnRegistered;

    @FXML
    private Button signoutBtn;

    @FXML
    private Pane ticketPaneRegistered;

    @FXML
    private TextField ticketid;

    @FXML
    private TextField ticketemail;

    @FXML
    private Button retrieveTicketBtn;

    @FXML
    private Text tickettheatre;

    @FXML
    private Text ticketmovie;

    @FXML
    private Text ticketroom;

    @FXML
    private Text ticketseat;

    @FXML
    private Text tickettime;

    @FXML
    private Button ticketDeleteBtn;

    @FXML
    private Text successfulTicketDlt;

    @FXML
    private Pane userInfoPaneRegistered;

    @FXML
    private Pane showtimePaneRegistered2;

    @FXML
    private Button returnToMovieSearchBtn;

    @FXML
    private Text movieSeatselectlable;

    @FXML
    private Button seatA1;

    @FXML
    private Button seatA2;

    @FXML
    private Button seatA3;

    @FXML
    private Button seatA4;

    @FXML
    private Button seatA5;

    @FXML
    private Button seatB1;

    @FXML
    private Button seatB2;

    @FXML
    private Button seatB3;

    @FXML
    private Button seatB4;

    @FXML
    private Button seatB5;

    @FXML
    private Pane showtimePaneRegistered1;

    @FXML
    private TextField creditCardField;

    @FXML
    private Text ticketPrice;

    @FXML
    private Button ticketPurchaseButtonRegistered1;

    @FXML
    private Button backButtonPaymentPage;

    @FXML
    private Pane showtimePaneRegistered;

    @FXML
    private ChoiceBox<Movie> movieChoiceBoxRegistered;

    @FXML
    private ChoiceBox<?> showtimeChoiceBoxRegistered;

    @FXML
    private Button currentlyShowingNextBtn;

    @FXML
    private Pane homePaneRegistered;

    @FXML
    private VBox pnItems;

    @FXML
    private ScrollPane scrollerNews;

    @FXML
    private VBox pnItems1;

    @FXML
    private ImageView announcementNotificationImg;

    @FXML
    private Label AnnouncementsTitle;

    @FXML
    private BorderPane loginHome;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginbutton;

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
    private TextField newUsername;


    @FXML
    void changePanelHome(ActionEvent event) {
        homePaneRegistered.toFront();
    }

    @FXML
    void changePanelSearchMovies(ActionEvent event) {
        showtimePaneRegistered.toFront();
        populateDropdownMovies();
    }

    void populateDropdownMovies(){
        ObservableList<Movie> list = FXCollections.observableArrayList();
        Database db = Database.getInstance();
        Theater t = db.getTheater();
        for( Map.Entry<String, Movie> m : t.getMovies().entrySet() ){
            list.add(m.getValue());
        }
        movieChoiceBoxRegistered.setItems(list);
        
    }

            //Theater t = db.getTheater();
        // for( Map.Entry<String, Movie> m : t.getMovies().entrySet() ){
        //     for(Showtime s : m.getValue().getShowtimes() ) {
        //         for(Map.Entry<String, Seat> x : s.getSeats().entrySet()) {
        //             x.getValue().setBooked(true);
        //             if(x.getValue().getIsMemberOnly())
        //                 db.updateSeatAvailability(t.getName(), m.getValue().getTitle(), s, x.getValue());
        //         }
        //     }
        // }

    @FXML
    void changePanelTickets(ActionEvent event) {
        ticketPaneRegistered.toFront();
        
    }

    @FXML
    void retrieveTicket(ActionEvent event) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        if (loggedInUser != null){
            ticketemail.setText(loggedInUser.getEmail());
        }
        Ticket newTicket = new Ticket(ticketid.getText(), null, null, ticketemail.getText(), 0, null, null);
        Database ticketfinder = Database.getInstance();
        newTicket = ticketfinder.findTicket(ticketid.getText(), ticketemail.getText());
        
        if (newTicket != null){
            tickettheatre.setText(newTicket.getTheater()); 
            ticketmovie.setText(newTicket.getMovie());
            ticketid.setText(newTicket.getId());
            int room = newTicket.getRoom();
            String wahoo = Integer.toString(room);
            ticketroom.setText(wahoo);
            ticketseat.setText(newTicket.getSeat());
            String formattedmovietime = newTicket.getTime().format(dateTimeFormatter);
            tickettime.setText(formattedmovietime);
            ticketDeleteBtn.setDisable(false);
            
        }
        else{
            Alert alert = new Alert(AlertType.ERROR, "No ticket found.", ButtonType.CLOSE);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE){
                alert.close();
            }
        }
    }
    @FXML
    void deleteTicket(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION, "Ticket Deleted.", ButtonType.CLOSE);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE){
                alert.close();
            }
        Database ticketfinder = Database.getInstance();
        ticketfinder.removeTicket(ticketid.getText(), ticketemail.getText());
        tickettheatre.setText(""); 
        ticketmovie.setText("");
        ticketid.setText("");
        ticketroom.setText("");
        ticketseat.setText("");
        tickettime.setText("");
        ticketDeleteBtn.setDisable(true);
        
    }
    @FXML
    void changePanelUserInfo(ActionEvent event) {
        userInfoPaneRegistered.toFront();
    }
    @FXML
    void userLogout(ActionEvent event) {
            loginHome.setVisible(true);
            loginHome.setDisable(false);
            registeredUserHome.setDisable(true);
            registeredUserHome.setVisible(false);
    }

    @FXML
    void userLogin(ActionEvent event) throws IOException, SQLException {
        checkLogin();
    }
    private void checkLogin() throws IOException, SQLException {
        userSingleton = UserEntrySingleton.getInstance();
        User user = userSingleton.validateAccount(username.getText().toString(), password.getText().toString());
        GUI m = new GUI();

        if (user == null) {
            if (username.getText().isEmpty() && password.getText().isEmpty()) {
                signUpSuccessfulLabel.setText("Please enter your username and password");
                signUpSuccessfulLabel.setTextFill(Color.RED);
            }
            else {
                signUpSuccessfulLabel.setText("Wrong username or password.");
                signUpSuccessfulLabel.setTextFill(Color.RED);
            }
        }
        else {
            loggedInUser = user;
            signUpSuccessfulLabel.setText("");
            loginHome.setVisible(false);
            loginHome.setDisable(true);
            registeredUserHome.setDisable(false);
            registeredUserHome.setVisible(true);
            userLoggedInShowField.setText(username.getText());
            AnnouncementsTitle.setVisible(true);
            announcementNotificationImg.setVisible(true);
            scrollerNews.setVisible(true);
        }
    }
    @FXML
    void continueUnregistered(ActionEvent event) throws IOException {
        loginHome.setVisible(false);
        registeredUserHome.setDisable(false);
        registeredUserHome.setVisible(true);
        loggedInUser = null;
        if (loggedInUser == null){
            userLoggedInShowField.setText("Guest");
            AnnouncementsTitle.setVisible(false);
            announcementNotificationImg.setVisible(false);
            scrollerNews.setVisible(false);
        }
        
        
    }
    @FXML
    void signUp(ActionEvent event) throws SQLException {
        checkSignUpValidity();
    }
    private void checkSignUpValidity() throws SQLException {
        userSingleton = UserEntrySingleton.getInstance();
        GUI m = new GUI();
        
        if (newEmail.getText().isEmpty() || newPassword.getText().isEmpty() || newCreditCard.getText().isEmpty() || 
        !Payment.validateCard(newCreditCard.getText())) {
            signUpSuccessfulLabel.setText("Please enter your details correctly.");
            signUpSuccessfulLabel.setTextFill(Color.RED);
        }
        else {
            User newUser = userSingleton.addRegisteredUser(newUsername.getText(), newPassword.getText(), newEmail.getText(), newCreditCard.getText());
            if (newUser == null) {
                signUpSuccessfulLabel.setText("An error occurred! Please check your email and password");
                signUpSuccessfulLabel.setTextFill(Color.RED);
            }
            else {
                signUpSuccessfulLabel.setText("Username registered!");
                signUpSuccessfulLabel.setTextFill(Color.GREEN);
                newUsername.clear();
                newPassword.clear();
                newEmail.clear();
                newCreditCard.clear();
            }
        }
    }

    @FXML
    void changeSeatA1(ActionEvent event) {

    }

    @FXML
    void changeSeatA2(ActionEvent event) {

    }

    @FXML
    void changeSeatA3(ActionEvent event) {

    }

    @FXML
    void changeSeatA4(ActionEvent event) {

    }

    @FXML
    void changeSeatA5(ActionEvent event) {

    }

    @FXML
    void changeSeatB1(ActionEvent event) {

    }

    @FXML
    void changeSeatB2(ActionEvent event) {

    }

    @FXML
    void changeSeatB3(ActionEvent event) {

    }

    @FXML
    void changeSeatB4(ActionEvent event) {

    }

    @FXML
    void changeSeatB5VIP(ActionEvent event) {

    }

    @FXML
    void nextFromCurrentlyShowing(ActionEvent event) {

    }

    @FXML
    void returnFromPayment(ActionEvent event) {

    }

    @FXML
    void returnToMovieSearch(ActionEvent event) {

    }



}
