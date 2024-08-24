package core.basesyntax;

import static core.basesyntax.Main.shop;

public class BalanceOperation extends OperationHandler {
    @Override
    public void run(FruitTransaction fruitTransaction) {
        shop.put(fruitTransaction.getFruitName(), fruitTransaction.getQuantity());
    }
}
