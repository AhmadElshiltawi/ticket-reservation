package Payment;
import java.util.UUID;

import  Entry.*;
import Theatre.Seat;
import Theatre.Showtime;

public class Ticket {
    // Field
    private String id = UUID.randomUUID().toString();
    private String theater;
    private String movie;
    private User user;
    private Showtime timeRoom;
    private Seat seat;

    // Constructor
    public Ticket(String theater, String movie, User user, Showtime timeRoom, Seat seat) {
        this.theater = theater;
        this.movie = movie;
        this.user = user;
        this.timeRoom = timeRoom;
        this.seat = seat;
    }

    // Methods
    public sendEmail(){
        
    }

    // Getter and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTheater() {
        return theater;
    }
    public void setTheater(String theater) {
        this.theater = theater;
    }
    public String getMovie() {
        return movie;
    }
    public void setMovie(String movie) {
        this.movie = movie;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Showtime getTimeRoom() {
        return timeRoom;
    }
    public void setTimeRoom(Showtime timeRoom) {
        this.timeRoom = timeRoom;
    }
    public Seat getSeat() {
        return seat;
    }
    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}

