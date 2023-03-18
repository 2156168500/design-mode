package stategy.example3;

import stategy.example2.Receipt;

public class ReceiptStrategyContext {
    public void handlerReceipt(Receipt receipt){
        if("A".equals(receipt.getType())){
            new A_ReceiptStrategy().handlerReceipt(receipt);
        }else if("B".equals(receipt.getType())){
            new B_ReceiptStrategy().handlerReceipt(receipt);
        }else if("C".equals(receipt.getType())){
            new C_ReceiptStrategy().handlerReceipt(receipt);
        }
    }
}
