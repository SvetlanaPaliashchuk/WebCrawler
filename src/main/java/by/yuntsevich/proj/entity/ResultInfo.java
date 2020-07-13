package by.yuntsevich.proj.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Yuntsevich Svetlana
 * Type ResultInfo represents crawler result (url, words to find, hits of each word)
 */
public class ResultInfo implements Serializable {

    private static final long serialVersionUID = -7603731383600246588L;
    /**
     * Html page URL from which the data is collected.
     */
    private String url;

    /**
     * Number of found words
     */
    private String hits;


    /**
     * Instantiates a new ResultInfo.
     *
     * @param url   the url
     * @param hits  the hits
     */
    public ResultInfo(String url, String hits) {
        this.url = url;
        this.hits = hits;
    }

    /**
     * Standard constructor
     */
    public ResultInfo() {
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
     * Gets hits.
     *
     * @return the hits
     */
    public String getHits() {
        return hits;
    }
    /**
     * Sets hits.
     *
     * @param hits the hits
     */
    public void setHits(String hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "url='" + url + '\'' +
                ", hits='" + hits + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultInfo that = (ResultInfo) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(hits, that.hits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, hits);
    }
}