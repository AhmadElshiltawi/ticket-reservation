package Payment;

public abstract class CostStrategy {
    private final double PRICE = 9.95;
    private final double TAX = .05;

    public abstract double refund();

    public double cost(){  
        return PRICE + PRICE*TAX;
    }

}
