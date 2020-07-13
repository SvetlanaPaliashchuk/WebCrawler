package by.yuntsevich.proj.dao;

import java.util.List;
import java.util.Set;

/**
 * Interface Writer
 */
public interface Writer {

    /**
     * Writes result.
     *
     * @param result   List<String>
     * @param fileName String
     * @throws DaoException dao exception
     */
    void writeResult(List<String> result, String fileName) throws DaoException;
}
