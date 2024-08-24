package core.basesyntax;

import static core.basesyntax.Main.shop;

public class SupplyOperation extends OperationHandler {
    public void run(FruitTransaction fruitTransaction) {
        shop.replace(fruitTransaction.getFruitName(),
                shop.get(fruitTransaction.getFruitName()) + fruitTransaction.getQuantity());
    }
}
