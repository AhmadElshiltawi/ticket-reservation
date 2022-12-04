package Payment;

public class RegisteredCost extends CostStrategy {

    // Overide cost to return whole value
    @Override
    public double refund() {
        return cost();
    }
    
}
