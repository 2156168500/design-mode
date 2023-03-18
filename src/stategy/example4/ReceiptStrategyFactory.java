package stategy.example4;

import stategy.example3.*;

import java.util.HashMap;
import java.util.Map;

public class ReceiptStrategyFactory {
    private static Map<String, ReceiptStrategy> map;
    static {
        map = new HashMap<>();
    }
    //将策略创建并存储起来
    public static void init(){
        map.put("A",new A_ReceiptStrategy());
        map.put("B",new B_ReceiptStrategy());
        map.put("C",new C_ReceiptStrategy());
        map.put("D",new D_ReceiptStrategy());
    }
    //提供获取具体策略的方法
    public  static ReceiptStrategy getReceiptStrategy(String type){
        return map.get(type);
    }
}
