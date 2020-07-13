package by.yuntsevich.proj.dao;

import by.yuntsevich.proj.dao.impl.CsvWriter;
import by.yuntsevich.proj.entity.CrawlerConfig;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CsvWriterTest {
    private List<String> result;
    private String fileName;
    private Writer csvWriter;


    @Before
    public void setUp() {
        result = new ArrayList<>();
        result.add("https://tools.ietf.org/html/rfc8446 0,11,1,0,12");
        result.add("https://jdk.java.net/java-se-ri/13 14,0,0,0,14");
        result.add("https://mkyong.com/tag/jdom/ 13,0,0,0,13");
        fileName = "output/test.csv";
        csvWriter = new CsvWriter();
    }

    @Test
    public void testWriteResult() throws DaoException {
        csvWriter.writeResult(result, fileName);
    }
}
