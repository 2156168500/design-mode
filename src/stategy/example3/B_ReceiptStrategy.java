package stategy.example3;

import stategy.example2.Receipt;

public class B_ReceiptStrategy implements ReceiptStrategy {

    @Override
    public void handlerReceipt(Receipt receipt) {
        System.out.println("B的回执信息被解析了，解析内容是 ： " + receipt.getMessage());
    }
}
