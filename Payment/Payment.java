package Payment;

import java.util.regex.*;
import java.util.UUID;
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
                {
                    double refund = strategy.refund();
                    EmailSender emailSender = new EmailSender();
                    String message = 
                            "Ticket Return.\n" + 
                            "Refund: " + String.format("%.2f", refund) +
                            "\nCredit Code: " + UUID.randomUUID().toString() +
                            "\nTicket ID: " + ticket.getId() + 
                            "\nSorry to see you go.";
                    emailSender.sendEmail(email, message);
                    return refund;  
                }
                              
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
            if(db.updateSeatAvailability(ticket.getTheater(),ticket.getMovie(),ticket.getRoom(),ticket.getTime(),ticket.getSeat(),true) > 0) {
                if(db.addTicket(ticket))
                {
                    double cost = strategy.cost();
                    EmailSender emailSender = new EmailSender();
                    String message = 
                            "Ticket Sale Processed!\n" + 
                            "Cost: " + String.format("%.2f", cost) +
                            "\nTicket ID: " + ticket.getId() + 
                            "\nThank you for your purchase!";
                    emailSender.sendEmail(email, message);
                    return cost; 
                }
            }
        }       
        return 0;
    }
}
