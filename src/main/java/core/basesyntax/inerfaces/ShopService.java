package core.basesyntax.inerfaces;

import core.basesyntax.models.FruitTransaction;

import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
}
