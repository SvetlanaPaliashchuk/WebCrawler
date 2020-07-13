package by.yuntsevich.proj.service.impl;

import by.yuntsevich.proj.dao.DaoException;
import by.yuntsevich.proj.dao.DaoFactory;
import by.yuntsevich.proj.dao.Writer;
import by.yuntsevich.proj.entity.ResultInfo;
import by.yuntsevich.proj.service.ServiceException;
import by.yuntsevich.proj.service.WebCrawlerService;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * This class implements the {@code WebCrawlerService} interface
 */
public class WebCrawlerServiceImpl implements WebCrawlerService {
    private static final String TOP_PAGES_FILE_PATH = "output/top.csv";
    private static final String ALL_PAGES_FILE_PATH = "output/allPages.csv";

    //get DaoFactory instance
    private final DaoFactory daoFactory = DaoFactory.getInstance();
    //get Writer instance
    private final Writer csvWriter = daoFactory.getCsvWriter();

    @Override
    public List<ResultInfo> getTopPagesByTotalHits(Set<ResultInfo> resultInfoSet, int topNumber) throws ServiceException {
        List<ResultInfo> topPagesByTotalHits = resultInfoSet.stream()
                .sorted(sortResultInfoByTotalHits)
                .limit(topNumber)
                .collect(Collectors.toList());
        saveResultInfo(topPagesByTotalHits, TOP_PAGES_FILE_PATH);
        return topPagesByTotalHits;
    }


    /**
     * Comparator sortResultInfoByTotalHits.
     */
    private final Comparator<ResultInfo> sortResultInfoByTotalHits = (o1, o2) -> {
        long totalHits1 = Long.parseLong(o1.getHits().split(",")[o1.getHits().split(",").length - 1]);
        long totalHits2 = Long.parseLong(o2.getHits().split(",")[o2.getHits().split(",").length - 1]);

        return (int) (totalHits2 - totalHits1);
    };

    @Override
    public Set<ResultInfo> getResultInfoSet(String url, int linkDepth, int maxPages, String words) throws ServiceException {
        Set<ResultInfo> result = new HashSet<>();
        Deque<String> links = new ArrayDeque<>();
        links.addFirst(url);
        List<String> inputWords = new ArrayList<>(Arrays.asList(words.split(",")));

        for (int i = 0; i < maxPages; i++) {
            Document document;
            try {
                String link = links.pollFirst();
                if (link != null) {
                    document = getDocumentByUrl(link);
                } else break;
                String hits = calculateHits(document, inputWords);
                ResultInfo resultInfo = new ResultInfo(link, hits);
                //System.out.println(link);
                //System.out.println(words);
                //System.out.println(hits);
                result.add(resultInfo);

                if (linkDepth > 0) {
                    addLinksToQueue(document, links);
                }
            } catch (IOException e) {
                // throw new ServiceException(e);
            }
            links.removeFirst();
            linkDepth--;
        }

        saveResultInfo(result, ALL_PAGES_FILE_PATH);
        return result;
    }

    /**
     * Calculates hits of input words on page
     * @param document Document
     * @param inputWords List<String>
     * @return string of hits. the last number is totalCount
     */
    private String calculateHits(Document document, List<String> inputWords) {
        String bodyOfHtml = document.body().text();
        long[] hits = new long[inputWords.size()];
        int index = 0;
        long totalCount = 0;

        for (String word : inputWords) {
            long temp = countMatchesInText(word, bodyOfHtml);
            hits[index] = temp;
            totalCount += temp;
            index++;
        }

        StringBuilder str = new StringBuilder();
        for (long hit : hits) {
            str.append(hit);
            str.append(",");
        }
        str.append(totalCount);
        return str.toString();
    }

    /**
     * Counts the number of hits of word in the given text
     * @param word String
     * @param text String
     * @return count long
     */
    private long countMatchesInText(String word, String text) {
        long count;
        Pattern pattern = Pattern.compile(word.toLowerCase());
        Matcher matcher = pattern.matcher(text.toLowerCase());
        count = matcher.results().count();
        return count;
    }

    /**
     * Connects to url and returns HTMLDocument
     * @param url String
     * @return Document
     * @throws IOException IOException
     */
    private Document getDocumentByUrl(String url) throws IOException {
            return Jsoup.connect(url).get();
    }

    /**
     * Scans links in Document and adds them to Queue
     * @param document Document
     * @param linksQueue Deque<String>
     * @throws ServiceException ServiceException
     */
    private void addLinksToQueue(Document document, Deque<String> linksQueue) throws ServiceException {
        if (document != null) {
            //get all references
            Elements refs = document.getElementsByTag("a");
            //get absolute paths
            for (Element element : refs) {
                linksQueue.addLast(element.attr("abs:href"));
            }
        } else {
            throw new ServiceException("Document cannot be null");
        }
    }

    /**
     * Transforms ResultInfo to String which can be written to the filr
     * @param resultInfo ResultInfo
     * @return String url + hits
     */
    private String createResultString(ResultInfo resultInfo) {
        return resultInfo.getUrl() + "," + resultInfo.getHits();
    }

    /**
     * Connects with Dao layer and saves info to file
     * @param result Collection<ResultInfo>
     * @param fileName String
     * @throws ServiceException ServiceException
     */
    private void saveResultInfo(Collection<ResultInfo> result, String fileName) throws ServiceException {
        List<String> resultInfo = new ArrayList<>();
        for (ResultInfo r : result) {
            resultInfo.add(createResultString(r));
        }
        try {
            csvWriter.writeResult(resultInfo, fileName);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
