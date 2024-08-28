package core.basesyntax.services;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.models.FruitTransaction;

import static core.basesyntax.DataBase.shop;


public class ReturnOperation extends OperationHandler {
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() > 0) {
            shop.replace(fruitTransaction.getFruitName(),
                    shop.get(fruitTransaction.getFruitName()) + fruitTransaction.getQuantity());
        }else
            throw new NumberFormatException("Return can not be less than 1");
    }
}
