package by.yuntsevich.proj.service.util;

import by.yuntsevich.proj.entity.CrawlerConfig;

import java.util.ResourceBundle;

/**
 * Type CrawlerConfigManager
 * reads config params from *.properties file
 */
public class CrawlerConfigManager {
    /**
     * CrawlerConfigManager INSTANCE
     */
    private static final CrawlerConfigManager INSTANCE = new CrawlerConfigManager();

    //define file
    private final ResourceBundle bundle = ResourceBundle.getBundle("application");

    /**
     * Gets CrawlerConfigManager INSTANCE
     *
     * @return INSTANCE
     */
    public static CrawlerConfigManager getInstance() {
        return INSTANCE;
    }

    /**
     * Gets CrawlerConfigManager INSTANCE
     *
     * @return INSTANCE
     */
    public String getValue(String key) {
        return bundle.getString(key);
    }

    /**
     * Initialize CrawlerConfig entity with the data from *.properties file
     * @return crawlerConfig
     */
    public CrawlerConfig initializeCrawlerConfig() {
        CrawlerConfig crawlerConfig = new CrawlerConfig();
        CrawlerConfigManager crawlerConfigManager = CrawlerConfigManager.getInstance();
        crawlerConfig.setUrl(crawlerConfigManager.getValue(CrawlerConfigParameter.SEED_URL));
        crawlerConfig.setWords(crawlerConfigManager.getValue(CrawlerConfigParameter.SEED_WORDS));
        crawlerConfig.setLinkDepth(Integer.parseInt(crawlerConfigManager.getValue(CrawlerConfigParameter.SEED_DEPTH)));
        crawlerConfig.setMaxPages(Integer.parseInt(crawlerConfigManager.getValue(CrawlerConfigParameter.SEED_PAGES)));

        return crawlerConfig;
    }
}