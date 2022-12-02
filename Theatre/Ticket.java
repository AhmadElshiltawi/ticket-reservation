package Theatre;

import  Entry.*;

public class Ticket {
    private int id;
    private Seat seat;
    private User user;
    private double price;

    public Ticket(int id, Seat seat, User user, double price) {
        this.id = id;
        this.seat = seat;
        this.user = user;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
