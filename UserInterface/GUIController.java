package UserInterface;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import Entry.*;
import Theatre.*;
import Project.*;
import Payment.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.util.regex.*;

public class GUIController {
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
    private Text wasPurchaseSuccessful;
    @FXML
    private Button purchaseTicketBtn;
    @FXML
    private Pane ticketPopupPane;
    @FXML
    private Text ticketOutput;
    @FXML
    private Text emailOutput;
    @FXML
    private TextField EmailFieldPayment;
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
    private Pane paymentPane;
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
    private ChoiceBox<String> movieChoiceBoxRegistered;
    @FXML
    private ChoiceBox<String> showtimeChoiceBoxRegistered;
    @FXML
    private Button currentlyShowingNextBtn;
    @FXML
    private Pane homePaneRegistered;
    @FXML
    private VBox pnItems;
    @FXML
    private Text seatNo;
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
    private Button seatSelectNextBtn;
    @FXML
    private Pane seatSelectPane;

    // Local Variables
    private UserEntrySingleton userSingleton;
    private User loggedInUser = null;
    Seat seat;
    HashMap<String, Seat> seats;

    

    private Movie getMovie(){
        return Database.getInstance().getTheater().getMovie(movieChoiceBoxRegistered.getValue());
    }
    
    private Showtime getShowtime() {
        Pattern pattern = Pattern.compile("room (\\d) : time (.+)$");
        Matcher matcher = pattern.matcher(showtimeChoiceBoxRegistered.getValue());
        if (matcher.find())
        {
            int room = Integer.parseInt(matcher.group(1));
            LocalDateTime time = LocalDateTime.parse(matcher.group(2));
            return getMovie().getShowtime(room, time);
        }
        return null;
    }

    @FXML
    void seatSelect(ActionEvent event) {
        Movie mov = getMovie();
        Showtime showtime = getShowtime();
        seats = showtime.getSeats();
        
        for( Map.Entry<String, Seat> seat : seats.entrySet()){
            if (loggedInUser == null){
                seatB5.setDisable(true);
            }
            seatAssignmentHelper(seat.getKey(), seat.getValue().getIsBooked());
        }
        showtime.getRoomNumber();
        seatSelectPane.toFront();
        movieSeatselectlable.setText(mov.getTitle());

    }

    void seatAssignmentHelper(String s, boolean tf){
        switch (s) {
            case "a1":
                seatA1.setDisable(tf);
                break;
            case "a2":
                seatA2.setDisable(tf);
                break;
            case "a3":
                seatA3.setDisable(tf);
                break;
            case "a4":
                seatA4.setDisable(tf);
                break;
            case "a5":
                seatA5.setDisable(tf);
                break;
            case "b1":
                seatB1.setDisable(tf);
                break;
            case "b2":
                seatB2.setDisable(tf);
                break;
            case "b3":
                seatB3.setDisable(tf);
                break;
            case "b4":
                seatB4.setDisable(tf);
                break;
            case "b5":
                seatB5.setDisable(tf);

                break;
                
            
            
            default:

                break;
        }
    }

    @FXML
    void changePanelHome(ActionEvent event) {
        homePaneRegistered.toFront();
        
    }

    @FXML
    void changePanelSearchMovies(ActionEvent event) {
        showtimePaneRegistered.toFront();
        seatB5.setStyle("-fx-background-color:#d4af37;");
        seatB5.setStyle("-fx-border-color:#d4af37;");
        populateDropdownMovies();
    }

    void populateDropdownMovies(){
        seatSelectNextBtn.setDisable(true);
        ObservableList<String> list = FXCollections.observableArrayList();
        Database db = Database.getInstance();
        Theater t = db.getTheater();
        for( Map.Entry<String, Movie> m : t.getMovies().entrySet() ){
            list.add(m.getKey());
        }
        movieChoiceBoxRegistered.setItems(list);
        movieChoiceBoxRegistered.setOnAction(this::populateDropdownShowtimes);
        
    }

    void activateSeatSelection(ActionEvent event){
        
        if(showtimeChoiceBoxRegistered.getValue() ==  null){
            seatSelectNextBtn.setDisable(true);
        }
        else{
            seatSelectNextBtn.setDisable(false);
        }
        
    }

    void populateDropdownShowtimes(ActionEvent event) {
        try {
        seatSelectNextBtn.setDisable(true);
        ObservableList<String> list2 = FXCollections.observableArrayList();
        Database db = Database.getInstance();
        Theater theater = db.getTheater();
        Movie movie = theater.getMovie(movieChoiceBoxRegistered.getValue());
        for(Showtime s : movie.getShowtimes() )
            list2.add("room " + s.getRoomNumber() + " : time " + s.getTime().toString());
        
        showtimeChoiceBoxRegistered.setItems(list2);
        showtimeChoiceBoxRegistered.setOnAction(this::activateSeatSelection);
        } catch (Exception e) {
            showtimeChoiceBoxRegistered.setItems(FXCollections.observableArrayList());
            seatSelectNextBtn.setDisable(true);
        }
        
    }

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
    // TODO delete ticket
    @FXML
    void deleteTicket(ActionEvent event) {
        Database db = Database.getInstance();
        Ticket ticket = db.findTicket(ticketid.getText(), ticketemail.getText());
        double refund = 0;
        if (  ticket != null)
        {
            if( loggedInUser == null)
            {
                refund = Payment.processReturn(ticket, new RegularCost());
            }
            else {
                refund = Payment.processReturn(ticket, new RegisteredCost());
            }

            if( refund != 0)
            {
                seat.setBooked(false);
                Alert alert = new Alert(AlertType.INFORMATION, "Ticket Deleted.\nRefund: "+String.format(".2%d",refund)+"\nEmail reciept sent", ButtonType.CLOSE);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.CLOSE){
                    alert.close();
                }
                tickettheatre.setText(""); 
                ticketmovie.setText("");
                ticketid.setText("");
                ticketroom.setText("");
                ticketseat.setText("");
                tickettime.setText("");
                ticketDeleteBtn.setDisable(true);
                return;
            }
        }

        Alert alert = new Alert(AlertType.INFORMATION, "Ticket NOT refunded!", ButtonType.CLOSE);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.CLOSE){
            alert.close();
        }
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
            homePaneRegistered.toFront();
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
            homePaneRegistered.toFront();
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
        seat = seats.get("a1");
        seatNo.setText("a1");
    }
    @FXML
    void changeSeatA2(ActionEvent event) {
        seat = seats.get("a2");
        seatNo.setText("a2");
    }

    @FXML
    void changeSeatA3(ActionEvent event) {
        seat = seats.get("a3");
        seatNo.setText("a3");
    }

    @FXML
    void changeSeatA4(ActionEvent event) {
        seat = seats.get("a4");
        seatNo.setText("a4");
    }

    @FXML
    void changeSeatA5(ActionEvent event) {
        seat = seats.get("a5");
        seatNo.setText("a5");
    }

    @FXML
    void changeSeatB1(ActionEvent event) {
        seat = seats.get("b1");
        seatNo.setText("b1");
    }

    @FXML
    void changeSeatB2(ActionEvent event) {
        seat = seats.get("b2");
        seatNo.setText("b2");
    }

    @FXML
    void changeSeatB3(ActionEvent event) {
        seat = seats.get("b3");
        seatNo.setText("b3");
    }

    @FXML
    void changeSeatB4(ActionEvent event) {
        seat = seats.get("b4");
        seatNo.setText("b4");
    }

    @FXML
    void changeSeatB5VIP(ActionEvent event) {
        seat = seats.get("b5");
        seatNo.setText("b5");
    }


    @FXML
    void returnFromPayment(ActionEvent event) {
        seatSelectPane.toFront();
    }

    @FXML
    void returnToMovieSearch(ActionEvent event) {
        showtimePaneRegistered.toFront();
        seat = null;
    }

    
    @FXML
    void continueToPayment(ActionEvent event) {
        if (seat != null){
            paymentPane.toFront();
            ticketPopupPane.setVisible(false);
            creditCardField.clear();
            EmailFieldPayment.clear();
        }
        else{
            System.out.println("meow");
        }

        if(loggedInUser != null){
            EmailFieldPayment.setText(loggedInUser.getEmail());
            // TODO PLEASE IMPLEMENT CREDIT CARD PASSED INTO THIS FUNCTION: MUST USE REGISTEREDUSER WE COULDNT FIGURE IT OUT w WHAT U HAD TY
        }
       

    }
    @FXML
    void ticketPurchase(ActionEvent event) {
        
        if(creditCardField.getText().isEmpty()){
            wasPurchaseSuccessful.setText("Please enter your credit card Number.");
            return;
        }
        if(!Payment.validateCard(creditCardField.getText())){
            wasPurchaseSuccessful.setText("Please enter your credit card Number.. CORRECTLY :)");
            return;
        }
        if(EmailFieldPayment.getText().isEmpty()){
            wasPurchaseSuccessful.setText("Please enter your email.");
            return;
        }
        if(!UserEntrySingleton.validateEmail(EmailFieldPayment.getText())){
            wasPurchaseSuccessful.setText("Please enter your email... CORRECTLY >:(");
            return;
        }

        // Purchase ticket
        Database db = Database.getInstance();
        Ticket ticket = new Ticket( db.getTheater().getName(), 
                                    getMovie().getTitle(), 
                                    EmailFieldPayment.getText(), 
                                    getShowtime().getRoomNumber(), 
                                    seat.getId(),
                                    getShowtime().getTime()
                                    );
        Double price = 0.0;
        if(loggedInUser == null)
            price = Payment.processSale(ticket, creditCardField.getText(), new RegularCost());
        else
            price = Payment.processSale(ticket, creditCardField.getText(), new RegisteredCost());
        
        if(price > 0) {
            seat.setBooked(true);
            wasPurchaseSuccessful.setFill(Color.GREEN);
            wasPurchaseSuccessful.setText("Thank you for your purchase!");
            ticketPrice.setText("$ " + String.format("%.2f", price));
            ticketPopupPane.setVisible(true);
            emailOutput.setText(EmailFieldPayment.getText());
            ticketOutput.setText(ticket.getId());
            creditCardField.clear();
            EmailFieldPayment.clear();
        }
        else {
            ticketPrice.setText(null);
            ticketPopupPane.setVisible(false);
            wasPurchaseSuccessful.setFill(Color.RED);
            wasPurchaseSuccessful.setText("Purchase Unsuccessfull");
        }         
    }

}
