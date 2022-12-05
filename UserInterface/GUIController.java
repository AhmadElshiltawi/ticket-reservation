package UserInterface;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import Theatre.*;
import Users.*;
import Payment.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.util.regex.*;
import Database.*;

public class GUIController {
    // FXML Components
    @FXML
    private BorderPane loginHome;
    @FXML
    private ScrollPane scrollerNews;
    @FXML
    private Pane ticketPaneRegistered,ticketPopupPane,userInfoPaneRegistered,showtimePaneRegistered2,paymentPane;
    @FXML
    private Pane showtimePaneRegistered,seatSelectPane,homePaneRegistered;
    @FXML
    private Button homeBtn, ticketBtn, showtimeBtn, userInfoBtnRegistered, signoutBtn, purchaseTicketBtn, retrieveTicketBtn;
    @FXML
    private Button ticketDeleteBtn, returnToMovieSearchBtn, ticketPurchaseButtonRegistered1, backButtonPaymentPage;
    @FXML
    private Button currentlyShowingNextBtn ,seatSelectNextBtn ,loginbutton ,signUpButton ,skipButton;
    @FXML
    private Button seatA1, seatA2, seatA3 ,seatA4 ,seatA5 ,seatB1 ,seatB2 ,seatB3 ,seatB4 , seatB5;
    @FXML
    private Text seatNo, ticketPrice, movieSeatselectlable, wasPurchaseSuccessful, ticketOutput, emailOutput;
    @FXML
    private Text tickettheatre, ticketmovie, ticketroom, ticketseat, tickettime, successfulTicketDlt;
    @FXML
    private TextField ticketid, ticketemail, EmailFieldPayment, creditCardField, newUsername, newEmail, username;
    @FXML
    private PasswordField newCreditCard, password, newPassword;
    @FXML
    private AnchorPane registeredUserHome;
    @FXML
    private Label userLoggedInShowField, AnnouncementsTitle, signUpSuccessfulLabel;
    @FXML
    private ChoiceBox<String> movieChoiceBoxRegistered, showtimeChoiceBoxRegistered;
    @FXML
    private VBox pnItems, pnItems1;
    @FXML
    private ImageView announcementNotificationImg;

    // Local Variables
    private UserEntrySingleton userSingleton;
    private User loggedInUser = null;
    Seat seat;
    HashMap<String, Seat> seats;
    
    // Helper Methods     
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

    private void seatAssignmentHelper(String s, boolean tf){
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
    
    private void populateDropdownMovies(){
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
    
    private void activateSeatSelection(ActionEvent event){
        
        if(showtimeChoiceBoxRegistered.getValue() ==  null){
            seatSelectNextBtn.setDisable(true);
        }
        else{
            seatSelectNextBtn.setDisable(false);
        }
        
    }

    private void populateDropdownShowtimes(ActionEvent event) {
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
                signUpSuccessfulLabel.setText("Username registered!\nRecurring payment setup! Next charge:" + LocalDateTime.now().plusYears(1));
                signUpSuccessfulLabel.setTextFill(Color.GREEN);
                Alert alert = new Alert(AlertType.INFORMATION, "Recurring payment setup! Next charge:" + LocalDateTime.now().plusYears(1), ButtonType.CLOSE);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.CLOSE){
                    alert.close();
                }
                newUsername.clear();
                newPassword.clear();
                newEmail.clear();
                newCreditCard.clear();
            }
        }
    }


    // Component press action events
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

    @FXML
    void changePanelTickets(ActionEvent event) {
        ticketemail.setText(null);
        ticketid.setText(null);
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
        Database db = Database.getInstance();
        Ticket ticket = db.findTicket(ticketid.getText(), ticketemail.getText());
        double refund = 0;
        if ( ticket != null)
        {
            boolean isRegistered= false;
            try {
                UserEntrySingleton singleton = UserEntrySingleton.getInstance();
                isRegistered = singleton.isUserRegistered(ticketemail.getText());
            } catch (Exception e) {}
            if( !isRegistered)
            {
                refund = Payment.processReturn(ticket, new RegularCost());
            }
            else {
                refund = Payment.processReturn(ticket, new RegisteredCost());
            }
            System.out.println(refund);
            
            if( refund != 0)
            {
                tickettheatre.setText(""); 
                ticketmovie.setText("");
                ticketid.setText("");
                ticketroom.setText("");
                ticketseat.setText("");
                tickettime.setText("");
                ticketDeleteBtn.setDisable(true);
                Alert alert = new Alert(AlertType.INFORMATION, "Ticket Deleted.\nRefund: "+ String.format("%.2f", refund)+"\nEmail reciept sent", ButtonType.CLOSE);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.CLOSE){
                    alert.close();
                }
            }
            else {
                Alert alert = new Alert(AlertType.INFORMATION, "Ticket NOT refunded!", ButtonType.CLOSE);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.CLOSE){
                    alert.close();
                }
            }
        } else {
            Alert alert = new Alert(AlertType.INFORMATION, "Ticket NOT found!", ButtonType.CLOSE);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE){
                alert.close();
            }
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
        showtimePaneRegistered.toFront();
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
            wasPurchaseSuccessful.setText(null);
            ticketPrice.setText(null);
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
        boolean isRegistered= false;
        try {
            UserEntrySingleton singleton = UserEntrySingleton.getInstance();
            isRegistered = singleton.isUserRegistered(EmailFieldPayment.getText());
        } catch (Exception e) {}
        if(!isRegistered)
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