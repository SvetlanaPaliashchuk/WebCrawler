package by.yuntsevich.proj.dao;

import by.yuntsevich.proj.dao.impl.CsvWriter;

/**
 * Class DaoFactory
 */
public class DaoFactory {
    /**
     * DaoFactory INSTANCE
     */
    private static final DaoFactory INSTANCE = new DaoFactory();

    /**
     * CSV_WRITER_INSTANCE
     */
    private static final Writer CSV_WRITER_INSTANCE = new CsvWriter();

    /**
     * Standard Constructor
     */
    private DaoFactory() {
    }

    /**
     * Gets DaoFactory INSTANCE
     *
     * @return INSTANCE
     */
    public static DaoFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Gets Writer INSTANCE
     *
     * @return CSV_WRITER_INSTANCE
     */
    public Writer getCsvWriter() {
        return CSV_WRITER_INSTANCE;
    }
}