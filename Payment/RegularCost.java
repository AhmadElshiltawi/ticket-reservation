package Payment;

public class RegularCost extends CostStrategy {
    private double ADMIN_FEE = 0.15;
    @Override
    public double refund() {
        double cost = cost();
        return cost - cost * ADMIN_FEE;
    }
    
}
