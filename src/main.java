public class main {
    public static void main(String[] args) {
        Cost cost = ConstFactory.getCost("正常收费");
        Cost cost1 = ConstFactory.getCost("打折收费");
        Cost cost2 = ConstFactory.getCost("满减收费");
    }
}
