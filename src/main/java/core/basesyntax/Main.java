package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Map<String, Integer> shop = new HashMap<>();

    public static void main(String[] arg) throws IOException {
        // 1. Read the data from the input CSV file
        List<String> inputReport = Files.readAllLines(Path.of("C:/txt/reportToRead.csv"));

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        Files.writeString(Path.of("C:/txt/finalReport.csv"), resultingReport);
    }
}
