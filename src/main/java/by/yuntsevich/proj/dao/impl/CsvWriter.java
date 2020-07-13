package by.yuntsevich.proj.dao.impl;

import by.yuntsevich.proj.dao.DaoException;
import by.yuntsevich.proj.dao.Writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Type CsvWriter
 */
public class CsvWriter implements Writer {

    /**
     * writes to the file
     */
    @Override
    public void writeResult(List<String> result, String fileName) throws DaoException {
        try {
            if (Files.notExists(Paths.get(fileName))) {
                Files.createFile(Paths.get(fileName));
            }

            Files.write(Paths.get(fileName), result);
        } catch (IOException e) {
            throw new DaoException("Problem in writing to the file", e);
        }
    }
}
