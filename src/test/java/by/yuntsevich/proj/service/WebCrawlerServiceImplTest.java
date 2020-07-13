package by.yuntsevich.proj.service;

import by.yuntsevich.proj.dao.DaoException;
import by.yuntsevich.proj.dao.DaoFactory;
import by.yuntsevich.proj.dao.Writer;
import by.yuntsevich.proj.dao.impl.CsvWriter;
import by.yuntsevich.proj.entity.ResultInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class WebCrawlerServiceImplTest {
    private ResultInfo resultInfo1;
    private ResultInfo resultInfo2;
    private ResultInfo resultInfo3;
    private ResultInfo resultInfo4;
    private ResultInfo resultInfo5;
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    WebCrawlerService webCrawlerService = serviceFactory.getWebCrawlerService();

    String url = "https://mkyong.com/";
    int linkDepth = 8;
    int maxPages = 5;
    String words = "test, java";


    @Before
    public void setUp() {

        resultInfo1 = new ResultInfo("https://mkyong.com/java/what-is-new-in-java-13/", "5,137,142");
        resultInfo2 = new ResultInfo("https://mkyong.com/java/what-is-new-in-java-11/","3,126,129");
        resultInfo3 = new ResultInfo("https://mkyong.com/", "1,36,37\n");
        resultInfo4 =new ResultInfo("https://mkyong.com/contact-mkyong/", "1,9,10");
        resultInfo5 = new ResultInfo("https://github.com/mkyong", "0,7,7");
    }

    @Test
    public void createResultString() throws  ServiceException {
        List<ResultInfo> myTestList = new ArrayList<>();
        myTestList.add(resultInfo1);
        myTestList.add(resultInfo2);
        myTestList.add(resultInfo3);
        myTestList.add(resultInfo4);
        myTestList.add(resultInfo5);
        Set<ResultInfo> res = webCrawlerService.getResultInfoSet(url, linkDepth, maxPages, words);
        System.out.println(res);
        List<ResultInfo> myTestList2 = webCrawlerService.getTopPagesByTotalHits(res, 10);
        //assertEquals(myTestList, myTestList2);
    }
}
