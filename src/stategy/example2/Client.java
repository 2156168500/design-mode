package stategy.example2;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Receipt> receiptList = ReceiptBuilder.getReceiptList();
        for(Receipt receipt : receiptList){
            if("A".equals(receipt.getType())){
                System.out.println("A的回执被解析了");
            }else if("B".equals(receipt.getType())){
                System.out.println("B的回执被解析了");
            }else if("C".equals(receipt.getType())){
                System.out.println("C的回执被解析了");
            }else if("D".equals(receipt.getType())){
                System.out.println("D的回执被解析了");
            }
        }
    }
}
