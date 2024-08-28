package core.basesyntax.services;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.inerfaces.OperationStrategy;
import core.basesyntax.models.FruitTransaction;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> map;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> map) {
        this.map = map;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction operation) {
       return map.get(operation.getActivity());
    }
}
