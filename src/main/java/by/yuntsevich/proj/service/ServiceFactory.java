package by.yuntsevich.proj.service;

import by.yuntsevich.proj.service.impl.WebCrawlerServiceImpl;
/**
 * Class ServiceFactory
 */
public class ServiceFactory {
    /**
     * ServiceFactory INSTANCE
     */
    private static final ServiceFactory INSTANCE = new ServiceFactory();
    /**
     * WEB_CRAWLER_SERVICE
     */
    private static final WebCrawlerService WEB_CRAWLER_SERVICE = new WebCrawlerServiceImpl();
    /**
     * Standard Constructor
     */
    private ServiceFactory() {}
    /**
     * Gets ServiceFactory INSTANCE
     *
     * @return INSTANCE
     */
    public static ServiceFactory getInstance() {
        return INSTANCE;
    }
    /**
     * Gets WebCrawlerService INSTANCE
     *
     * @return WEB_CRAWLER_SERVICE
     */
    public WebCrawlerService getWebCrawlerService() {
        return WEB_CRAWLER_SERVICE;
    }


}