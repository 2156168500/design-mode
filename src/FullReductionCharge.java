/**
 * 满减收费的类
 */
public class FullReductionCharge extends Cost {
    private final double full;
    private final double reduction;
    public FullReductionCharge(double full,double reduction){
        this.full = full;
        this.reduction = reduction;
    }
    @Override
    public double collectFees(double price) {
        double rest = 0;
        if(price < full){
            rest = price;
        }else{
            rest = price - reduction * (price / full );
        }
        return rest;
    }
}
