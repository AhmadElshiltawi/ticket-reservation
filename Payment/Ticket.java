package Payment;
import java.time.LocalDateTime;
import java.util.UUID;
import Project.*;

public class Ticket {
    // Field
    private String id = UUID.randomUUID().toString();
    private String theater;
    private String movie;
    private String email;
    private int room;
    private String seat;
    private LocalDateTime time;

    // Constructor
    public Ticket(String theater, String movie, String email, int room, String seat, LocalDateTime time) {
        this.theater = theater;
        this.movie = movie;
        this.email = email;
        this.room = room;
        this.seat = seat;
        this.time = time;
    }

    public Ticket(String id, String theater, String movie, String email, int room, String seat, LocalDateTime time) {
        this.id = id;
        this.theater = theater;
        this.movie = movie;
        this.email = email;
        this.room = room;
        this.seat = seat;
        this.time = time;
    }

    // Methods
    public void sendEmail(){

    }

    public boolean isRefundable() {
        LocalDateTime time = this.time.minusHours(72);
        return LocalDateTime.now().isBefore(time);
        
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }    
}

