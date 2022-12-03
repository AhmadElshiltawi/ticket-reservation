package Payment;

import Project.Database;

public class Payment {

    public static double processReturn(Ticket ticket, CostStrategy strategy) {
        Database db = Database.getInstance();
        String id = ticket.getId();
        String email = ticket.getEmail();
        if( db.findTicket(id,email) != null )
            if(db.removeTicket(id, email))
                return strategy.refund();            
        return 0;
    }

    public static double processSale(Ticket ticket, CostStrategy strategy) {
        Database db = Database.getInstance();
        String id = ticket.getId();
        String email = ticket.getEmail();
        if( db.findTicket(id,email) == null )
            if(db.addTicket(ticket))
                return strategy.cost();  
        return 0;
    }

}
