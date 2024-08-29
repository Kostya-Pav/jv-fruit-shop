package core.basesyntax.services;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.models.FruitTransaction;

import static core.basesyntax.DataBase.shop;

public class PurchaseOperation extends OperationHandler {
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() > 0
                && fruitTransaction.getQuantity() < shop.get(fruitTransaction.getFruitName())) {
            shop.replace(fruitTransaction.getFruitName(),
                    shop.get(fruitTransaction.getFruitName()) - fruitTransaction.getQuantity());
        } else
            throw new NumberFormatException("Purchase can not be less than 1 or more than we have");
    }
}
