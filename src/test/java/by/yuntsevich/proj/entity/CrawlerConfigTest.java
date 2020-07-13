package by.yuntsevich.proj.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CrawlerConfigTest {
    private String url;
    private String words;
    private int linkDepth;
    private int maxPages;
    private CrawlerConfig crawlerConfig;

    @Before
    public void setUp() {
        url = "https://spring.io";
        words = "Java,flow,generic,buffer";
        linkDepth = 4;
        maxPages = 80;
        crawlerConfig = new CrawlerConfig(url, words, linkDepth, maxPages);
    }

    @Test
    public void getUrl() {
        assertEquals(url, crawlerConfig.getUrl());
    }

    @Test
    public void getWords() {
        assertEquals("Java" + "," + "flow" + "," + "generic" + "," + "buffer", crawlerConfig.getWords());
    }

    @Test
    public void getLinkDepth() {
        assertEquals(linkDepth, crawlerConfig.getLinkDepth());
    }

    @Test
    public void getMaxPages() {
        assertEquals(maxPages, crawlerConfig.getMaxPages());
    }

    @Test
    public void checkCreationNewCrawlerConfig() {
        String url = "https://spring.io";
        String words = "Java,flow,generic,buffer";
        int linkDepth = 4;
        int maxPages = 80;
        CrawlerConfig crawlerConfig2 = new CrawlerConfig(url, words, linkDepth, maxPages);

        Assert.assertEquals(url, crawlerConfig2.getUrl());
        Assert.assertEquals(words, crawlerConfig2.getWords());
        Assert.assertEquals(linkDepth, crawlerConfig2.getLinkDepth());
        Assert.assertEquals(maxPages, crawlerConfig2.getMaxPages());
    }
}