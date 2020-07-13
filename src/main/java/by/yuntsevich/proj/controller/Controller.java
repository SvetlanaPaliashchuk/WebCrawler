package by.yuntsevich.proj.controller;


import by.yuntsevich.proj.entity.CrawlerConfig;
import by.yuntsevich.proj.entity.ResultInfo;
import by.yuntsevich.proj.service.ServiceException;
import by.yuntsevich.proj.service.ServiceFactory;
import by.yuntsevich.proj.service.WebCrawlerService;
import by.yuntsevich.proj.service.impl.WebCrawlerServiceImpl;
import by.yuntsevich.proj.service.util.CrawlerConfigManager;

import java.util.List;
import java.util.Set;

public class Controller {

    public void executeTask() throws ServiceException {

        /*initialize CrawlerConfig
        reads input data from application properties
        */
        CrawlerConfig crawlerConfig = CrawlerConfigManager.getInstance().initializeCrawlerConfig();
        String url = crawlerConfig.getUrl();
        int linkDepth = crawlerConfig.getLinkDepth();
        int maxPages = crawlerConfig.getMaxPages();
        String words = crawlerConfig.getWords();

        //get ServiceFactory instance
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        //get WebCrawlerService instance
        WebCrawlerService webCrawlerService = serviceFactory.getWebCrawlerService();
        //get all web crawler results
        Set<ResultInfo> allResults = webCrawlerService.getResultInfoSet(url, linkDepth, maxPages, words);
        //get top 10 web crawler results
        List<ResultInfo> top10Results = webCrawlerService.getTopPagesByTotalHits(allResults, 10);
    }
}