package core.basesyntax;

import java.util.stream.Collectors;
import static core.basesyntax.Main.shop;
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
