package Theatre;

import java.util.ArrayList;

public class Showroom {
    private String name;
    private ArrayList<Showtime> showtimes;
    private ArrayList<Seat> seats;

    public  Showroom(String name) {
        //****???
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Showtime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(ArrayList<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public void add(Showtime showtime) {
        showtimes.add(showtime);
    }

    public void add(Seat seat) {
        seats.add(seat);
    }

    public void remove(Showtime showtime) {
        showtimes.remove(showtime);
    }

    public void remove(Seat seat) {
        seats.remove(seat);
    }
}
