package by.yuntsevich.proj.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResultInfoTest {

    private String url;
    private String hits;
    private ResultInfo resultInfo;

    @Before
    public void setUp() {
        url = "www.testurl.com";
        hits = "8,0,0,4,12";
        resultInfo = new ResultInfo(url, hits);
    }

    @Test
    public void getUrl() {
        assertEquals(url, resultInfo.getUrl());
    }

    @Test
    public void setUrl() {
        resultInfo.setUrl("www.seturl.net");
        assertEquals("www.seturl.net", resultInfo.getUrl());

    }

    @Test
    public void getHits() {
        String hits2 = "8,0,0,4,12";
        assertEquals(hits2, resultInfo.getHits());
    }

    @Test
    public void setHits() {
        String hits2 = "0,0,0,2,2";

        resultInfo.setHits(hits2);
        assertEquals(hits2, resultInfo.getHits());
    }

    @Test
    public void checkCreatingNewResultInfo() {
        String url = "www.testurl.com";
        String hits = "8,0,0,4,12";
        ResultInfo resultInfo = new ResultInfo(url, hits);

        Assert.assertEquals(url, resultInfo.getUrl());
        Assert.assertEquals(hits, resultInfo.getHits());
    }
}