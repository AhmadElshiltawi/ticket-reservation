package Theatre;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Showtime {
    private int roomNumber;
    private LocalDateTime time;
    private HashMap<String, Seat> seats;

    // Constructor
    public Showtime(int roomNumber, int year, int month, int day, int hour, int minute){
        this.roomNumber = roomNumber;
        time = LocalDateTime.of(year, month, day, hour, minute);
        seats = new HashMap<>();
    }

    // Methods
    public void add(Seat seat){
        seats.put(seat.getId(), seat);
    }

    // Getters and Setters
    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public HashMap<String, Seat> getSeats() {
        return seats;
    }
    public void setSeats(HashMap<String, Seat> seats) {
        this.seats = seats;
    }
    
    // Overridden functions
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Showtime)) return false;
        Showtime time = (Showtime) obj;
        return time.time.isEqual(this.time) && time.roomNumber == this.roomNumber;
    }
    @Override
    public int hashCode() {
        int result=17;
        result+=31*roomNumber;
        result=31*result+(time!=null ? time.hashCode():0);
        return result;
    }
}
