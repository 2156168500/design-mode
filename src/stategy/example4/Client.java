package stategy.example4;

import stategy.example2.Receipt;
import stategy.example2.ReceiptBuilder;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Receipt> receiptList = ReceiptBuilder.getReceiptList();
        //获取策略的上下文对象
        ReceiptStrategyContext context = new ReceiptStrategyContext();
        for(Receipt receipt : receiptList){
            context.handlerReceipt(receipt);
        }
    }
}
