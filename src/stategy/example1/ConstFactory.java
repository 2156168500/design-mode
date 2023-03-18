package stategy.example1;

/**
 * 创建收费类的工厂
 */
public final class ConstFactory {
    public  static Cost getCost(String constName){
        Cost cost = null;
        if("正常收费".equals(constName)){
            cost = new NormalCharge();
        }else if("打折收费".equals(constName)){
            cost = new DiscountCharge(0.8);
        }else if("满减收费".equals(constName)){
            cost = new FullReductionCharge(300,50);
        }
        return cost;
    }
}
