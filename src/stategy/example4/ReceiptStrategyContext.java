package stategy.example4;

import org.jetbrains.annotations.NotNull;
import stategy.example2.Receipt;
import stategy.example3.ReceiptStrategy;

public class ReceiptStrategyContext {
    public void handlerReceipt(@NotNull Receipt receipt){
        //创建策略
        ReceiptStrategyFactory.init();
        //获取 策略
        ReceiptStrategy receiptStrategy = ReceiptStrategyFactory.getReceiptStrategy(receipt.getType());
       //使用策略
       receiptStrategy.handlerReceipt(receipt);
    }
}
