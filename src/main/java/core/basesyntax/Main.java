package core.basesyntax;

import core.basesyntax.handlers.DataConverterImpl;
import core.basesyntax.handlers.FileReaderImpl;
import core.basesyntax.handlers.FileWriterImpl;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.ReportGeneratorImpl;
import core.basesyntax.inerfaces.DataConverter;
import core.basesyntax.inerfaces.FileReader;
import core.basesyntax.inerfaces.FileWriter;
import core.basesyntax.inerfaces.OperationStrategy;
import core.basesyntax.inerfaces.ReportGenerator;
import core.basesyntax.inerfaces.ShopService;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.BalanceOperation;
import core.basesyntax.services.OperationStrategyImpl;
import core.basesyntax.services.PurchaseOperation;
import core.basesyntax.services.ReturnOperation;
import core.basesyntax.services.ShopServiceImpl;
import core.basesyntax.services.SupplyOperation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] arg) throws IOException {
        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("C:/txt/reportToRead.csv");

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

        /// 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "C:/txt/finalReport.csv");
    }
}
