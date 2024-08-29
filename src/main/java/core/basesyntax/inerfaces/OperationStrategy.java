package core.basesyntax.inerfaces;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.models.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction operation);
}
