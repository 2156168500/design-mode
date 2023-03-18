package stategy.example1;

/**
 * 打折收费的类
 */
public class DiscountCharge extends Cost{
    private double discount;
    public DiscountCharge(double discount){
        this.discount = discount;
    }
    @Override
    public double collectFees(double price) {
        return price * price;
    }
}
