package core.basesyntax.handlers;

import core.basesyntax.inerfaces.DataConverter;
import core.basesyntax.models.FruitTransaction;

import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> list) {
        return list.stream()
                .skip(1)
                .map(string -> string.strip().split(","))
                .map(array ->
                        new FruitTransaction(FruitTransaction.Operation.fromCode(array[0]),
                                array[1],
                                Integer.parseInt(array[2]))).toList();
    }
}
