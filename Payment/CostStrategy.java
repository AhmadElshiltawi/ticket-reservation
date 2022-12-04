package Payment;

public abstract class CostStrategy {
    // Fields
    private final double PRICE = 9.95;
    private final double TAX = .05;

    // The amound that needs to be refunded
    public abstract double refund();

    // Default cost for every strategy
    public double cost(){  
        return PRICE + PRICE*TAX;
    }

}
