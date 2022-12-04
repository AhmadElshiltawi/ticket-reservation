package Payment;

import java.util.regex.*;

import Database.Database;

public class Payment {
    // Checks to see if credit card is valid
    public static boolean validateCard(String credit) {
        Pattern pattern = Pattern.compile("\\b\\d{16,16}$");
        Matcher matcher = pattern.matcher(credit);
        return matcher.find();
    }
    // Process a return given a ticket and strategy. Cannot return twice
    public static double processReturn(Ticket ticket, CostStrategy strategy) {

        Database db = Database.getInstance();
        String id = ticket.getId();
        String email = ticket.getEmail();
        if( db.findTicket(id,email) != null && ticket.isRefundable())
            if(db.updateSeatAvailability(
                ticket.getTheater(),
                ticket.getMovie(),
                ticket.getRoom(),
                ticket.getTime(),
                ticket.getSeat(), false) 
                > 0)
                if(db.removeTicket(id, email))
                    return strategy.refund();            
        return 0;
    }
    // Process Sale given a ticket, credit card and strategy. Cannot get seat thats already booked
    public static double processSale(Ticket ticket,  String credit, CostStrategy strategy) {
        Database db = Database.getInstance();
        String id = ticket.getId();
        String email = ticket.getEmail();

        boolean available = !db.getSeatAvailability(ticket.getTheater(),ticket.getMovie(),ticket.getRoom(),ticket.getTime(),ticket.getSeat());
        if( db.findTicket(id,email) == null && available)
        {
            System.out.println("ticket not found");
            if(db.updateSeatAvailability(ticket.getTheater(),ticket.getMovie(),ticket.getRoom(),ticket.getTime(),ticket.getSeat(),true) > 0) {
                System.out.println("Seat updated");
                if(db.addTicket(ticket))
                {
                    System.out.println("ticket added");
                    return strategy.cost(); 
                }
            }
        }       
        return 0;
    }
}
