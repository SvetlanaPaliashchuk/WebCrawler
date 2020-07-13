package by.yuntsevich.proj.entity;

import java.util.Objects;

/**
 * @author Yuntsevich Svetlana
 * Type CrawlerConfig defines configuration parameters
 */
public class CrawlerConfig {
    private static final long serialVersionUID = -1356569743527024580L;
    /**
     * Seed url
     */
    private String url;
    /**
     * Words to find on pages
     */
    private String words;
    /**
     * Depth of links
     */
    private int linkDepth;
    /**
     * Max pages to crawl
     */
    private int maxPages;

    /**
     * Instantiates a new CrawlerConfig.
     *
     * @param url       the url
     * @param words     the words
     * @param linkDepth the depth of links
     * @param maxPages  the pages max
     */
    public CrawlerConfig(String url, String words, int linkDepth, int maxPages) {
        this.url = url;
        this.words = words;
        this.linkDepth = linkDepth;
        this.maxPages = maxPages;
    }

    /**
     * Standard constructor
     */
    public CrawlerConfig() {
    }
    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * Gets words.
     *
     * @return the words
     */
    public String getWords() {
        return words;
    }
    /**
     * Sets words.
     *
     * @param words the words
     */
    public void setWords(String words) {
        this.words = words;
    }
    /**
     * Gets link depth.
     *
     * @return the linkDepth
     */
    public int getLinkDepth() {
        return linkDepth;
    }
    /**
     * Sets link depth.
     *
     * @param linkDepth the linkDepth
     */
    public void setLinkDepth(int linkDepth) {
        this.linkDepth = linkDepth;
    }
    /**
     * Gets max pages.
     *
     * @return the max pages
     */
    public int getMaxPages() {
        return maxPages;
    }
    /**
     * Sets max pages.
     *
     * @param maxPages the max pages
     */
    public void setMaxPages(int maxPages) {
        this.maxPages = maxPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrawlerConfig that = (CrawlerConfig) o;
        return linkDepth == that.linkDepth &&
                maxPages == that.maxPages &&
                Objects.equals(url, that.url) &&
                Objects.equals(words, that.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, words, linkDepth, maxPages);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "url='" + url + '\'' +
                ", words='" + words + '\'' +
                ", linkDepth=" + linkDepth +
                ", maxPages=" + maxPages +
                '}';
    }
}
