package Payment;

import java.util.regex.*;

import Project.Database;

public class Payment {
    public static boolean validateCard(String credit) {
        credit = credit.replaceAll("[^\\d]", "");
        Pattern pattern = Pattern.compile("\\b\\d{16,16}$");
        Matcher matcher = pattern.matcher(credit);
        return matcher.find();
    }

    public static double processReturn(Ticket ticket, CostStrategy strategy) {

        Database db = Database.getInstance();
        String id = ticket.getId();
        String email = ticket.getEmail();
        if( db.findTicket(id,email) != null )
            if(db.removeTicket(id, email))
                return strategy.refund();            
        return 0;
    }

    public static double processSale(Ticket ticket,  String credit, CostStrategy strategy) {
        Database db = Database.getInstance();
        String id = ticket.getId();
        String email = ticket.getEmail();
        if( db.findTicket(id,email) == null && validateCard(credit))
            if(db.addTicket(ticket))
                return strategy.cost();  
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Payment.validateCard("1234-5678-1234-1234"));
    }

}
