package Payment;

public class RegularCost extends CostStrategy {
    private double ADMIN_FEE = 0.15;
    
    // Refund cost minus admin fee
    @Override
    public double refund() {
        double cost = cost();
        return cost - cost * ADMIN_FEE;
    }
    
}
