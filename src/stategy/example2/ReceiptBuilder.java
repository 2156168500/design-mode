package stategy.example2;

import java.util.ArrayList;
import java.util.List;

public class ReceiptBuilder {
    private static List<Receipt> list;
     static {
        list = new ArrayList<>();
    }
    public static List<Receipt> getReceiptList(){
        list.add(new Receipt("A","A的回执信息"));
        list.add(new Receipt("B","B的回执信息"));
        list.add(new Receipt("C","C的回执信息"));
        list.add(new Receipt("D","D的回执信息"));
        return list;
    }
}
