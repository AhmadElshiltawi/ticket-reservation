package Payment;

import java.util.regex.*;

import Project.Database;

public class Payment {
    public static boolean validateCard(String credit) {
        //credit = credit.replaceAll("[^\\d]", "");
        Pattern pattern = Pattern.compile("\\b\\d{16,16}$");
        Matcher matcher = pattern.matcher(credit);
        return matcher.find();
    }

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

    public static void main(String[] args) {
        System.out.println(Payment.validateCard("1234-5678-1234-1234"));
    }

}
