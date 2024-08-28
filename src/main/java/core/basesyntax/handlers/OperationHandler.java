package core.basesyntax.handlers;

import core.basesyntax.models.FruitTransaction;

public abstract class OperationHandler {
    public abstract void handle(FruitTransaction fruitTransaction);
}
