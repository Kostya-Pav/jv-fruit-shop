package core.basesyntax;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        {
            for (FruitTransaction transaction : transactions) {
                operationStrategy.getHandler(transaction);
            }
        }
    }
}
