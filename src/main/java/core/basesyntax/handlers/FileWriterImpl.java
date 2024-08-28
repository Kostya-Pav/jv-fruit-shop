package core.basesyntax.handlers;

import core.basesyntax.inerfaces.FileWriter;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String resultingReport, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))){
            bufferedWriter.write(resultingReport);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
