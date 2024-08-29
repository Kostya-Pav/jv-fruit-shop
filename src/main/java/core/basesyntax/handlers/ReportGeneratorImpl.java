package core.basesyntax.handlers;

import core.basesyntax.inerfaces.ReportGenerator;

import java.util.stream.Collectors;

import static core.basesyntax.DataBase.shop;
import static java.lang.System.lineSeparator;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        return shop.entrySet()
                .stream()
                .map(entry -> "b," + entry.getKey() + "," + entry.getValue() + lineSeparator())
                .collect(Collectors.joining());
    }
}
