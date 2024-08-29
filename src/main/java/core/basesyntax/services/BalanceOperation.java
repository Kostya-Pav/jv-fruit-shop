package core.basesyntax.services;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.models.FruitTransaction;

import static core.basesyntax.DataBase.shop;

public class BalanceOperation extends OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() > 0) {
            shop.put(fruitTransaction.getFruitName(), fruitTransaction.getQuantity());
        } else
            throw new NumberFormatException("Balance can not be less than 1");
    }
}
