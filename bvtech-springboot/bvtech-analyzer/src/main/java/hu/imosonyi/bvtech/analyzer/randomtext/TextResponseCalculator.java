package hu.imosonyi.bvtech.analyzer.randomtext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import hu.imosonyi.bvtech.analyzer.dto.ApiStatistics;
import hu.imosonyi.bvtech.analyzer.dto.TextRequest;
import hu.imosonyi.bvtech.analyzer.dto.TextResponse;

/**
 * Calculates the analysis report.
 *
 * @author István Mosonyi
 */
public class TextResponseCalculator {

    private ApiStatistics apiStatistics;

    @Autowired
    private ApiClient apiClient;

    @Autowired
    private ApiResponseProcessor apiResponseProcessor;

    @Autowired
    private ApiPathGenerator apiPathGenerator;

    /**
     * Creates the analysis report for the /betvictor/text request.
     *
     * @param textRequest The /betvictor/text request to analyse.
     * @return Analysis report of the paragraphs.
     */
    public TextResponse calculate (TextRequest textRequest) {
        apiStatistics = new ApiStatistics();
        apiStatistics.setStart(System.currentTimeMillis());
        List<CompletableFuture<Void>> apiCalls = new ArrayList<>();
        for (String path : apiPathGenerator.getPaths(textRequest)) {
            apiCalls.add(callApiAndAnalize(path));
        }
        apiCalls.stream().map(CompletableFuture::join).collect(Collectors.toList());
        apiStatistics.setEnd(System.currentTimeMillis());
        return getTextResponse();
    }

    public void addTime (Long start) {
        apiStatistics.addTime(start);
    }

    public void addSize (Integer size) {
        apiStatistics.addSize(size);
    }

    public void addWord (String word) {
        apiStatistics.addWord(word);
    }

    private CompletableFuture<Void> callApiAndAnalize (String path) {
        return apiClient.request(path).thenAcceptAsync(apiResponseProcessor::process);
    }

    private TextResponse getTextResponse () {
        TextResponse textResponse = new TextResponse();
        textResponse.setAverageTime(apiStatistics.getAverageTime());
        textResponse.setAverageSize(apiStatistics.getAverageSize());
        textResponse.setMostFrequent(apiStatistics.getMostFrequentWord());
        textResponse.setTotalTime(apiStatistics.getTotalTime());
        return textResponse;
    }

}
