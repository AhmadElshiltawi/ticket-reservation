package Payment;

public class RegisteredCost extends CostStrategy {

    @Override
    public double refund() {
        return cost();
    }
    
}
