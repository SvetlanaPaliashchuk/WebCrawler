package by.yuntsevich.proj.service;

import by.yuntsevich.proj.dao.DaoException;
import by.yuntsevich.proj.entity.ResultInfo;

import java.util.List;
import java.util.Set;

/**
 * interface public interface WebCrawlerService {
 */
public interface WebCrawlerService {
    /**
     * Get Set of ResultInfo
     *
     * @param url       String
     * @param linkDepth int
     * @param maxPages  int
     * @param words     String
     * @return resultInfoSet
     * @throws ServiceException ServiceException
     */
    Set<ResultInfo> getResultInfoSet(String url, int linkDepth, int maxPages, String words) throws ServiceException;

    /**
     * Get top number of pages by total hits
     *
     * @param resultInfoSet Set<ResultInfo>
     * @param topNumber     int number of pages in statistics
     * @return topResultInfoList
     * @throws ServiceException ServiceException
     */
    List<ResultInfo> getTopPagesByTotalHits(Set<ResultInfo> resultInfoSet, int topNumber) throws ServiceException;

}
