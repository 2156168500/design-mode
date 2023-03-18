package stategy.example3;

import stategy.example2.Receipt;
import stategy.example2.ReceiptBuilder;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Receipt> receiptList = ReceiptBuilder.getReceiptList();
        //获取策略类的上下文对象
        ReceiptStrategyContext context = new ReceiptStrategyContext();
        for(Receipt receipt : receiptList){
            //执行策略
            context.handlerReceipt(receipt);
        }
    }
}
