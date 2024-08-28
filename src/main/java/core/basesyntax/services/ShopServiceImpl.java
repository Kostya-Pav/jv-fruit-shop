package core.basesyntax.services;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.inerfaces.OperationStrategy;
import core.basesyntax.inerfaces.ShopService;
import core.basesyntax.models.FruitTransaction;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operation = operationStrategy.getHandler(transaction);
            operation.handle(transaction);
        }
    }
}
