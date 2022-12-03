package Payment;

import Project.Database;

public class Payment {

    public static double processReturn(Ticket ticket, CostStrategy strategy) {
        Database db = Database.getInstance();
        String id = ticket.getId();
        String email = ticket.getUser().getEmail();
        if( db.findTicket(id,email) )
            if(db.removeTicket(id, email))
                return strategy.refund();            
        return 0;
    }

    public static double processSale(Ticket ticket, CostStrategy strategy) {
        Database db = Database.getInstance();
        String id = ticket.getId();
        String email = ticket.getUser().getEmail();
        if( !db.findTicket(id,email) )
            if(db.addTicket(id, email))
                return strategy.cost();  
        return 0;
    }

}
