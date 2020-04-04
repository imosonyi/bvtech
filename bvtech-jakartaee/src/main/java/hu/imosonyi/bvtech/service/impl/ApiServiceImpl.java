package hu.imosonyi.bvtech.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;

import hu.imosonyi.bvtech.dto.ParagraphStatistics;
import hu.imosonyi.bvtech.dto.TextRequest;
import hu.imosonyi.bvtech.dto.TextResponse;
import hu.imosonyi.bvtech.randomtext.ApiClient;
import hu.imosonyi.bvtech.randomtext.ApiPathGenerator;
import hu.imosonyi.bvtech.randomtext.ApiResponseProcessor;
import hu.imosonyi.bvtech.service.ApiService;

/**
 * Implements the {@link ApiService} interface.
 *
 * @author István Mosonyi
 */
@RequestScoped
public class ApiServiceImpl implements ApiService {

    private ApiPathGenerator apiPathGenerator = new ApiPathGenerator();

    private ApiClient apiClient = new ApiClient();

    @Override
    public TextResponse analyze (TextRequest textRequest) {
        final long start = System.currentTimeMillis();

        List<ParagraphStatistics> paragraphStatistics = getParagraphStatistics(textRequest);
        TextResponse textResponse = getTextResponse(paragraphStatistics);

        final long end = System.currentTimeMillis();
        textResponse.setTotalTime(end - start);
        return textResponse;
    }

    private List<ParagraphStatistics> getParagraphStatistics (TextRequest textRequest) {
        List<CompletableFuture<List<ParagraphStatistics>>> apiCalls = new ArrayList<>();
        for (String path : apiPathGenerator.getPaths(textRequest)) {
            apiCalls.add(callApiAndAnalize(path));
        }
        return apiCalls.stream()
                .map(CompletableFuture::join)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private CompletableFuture<List<ParagraphStatistics>> callApiAndAnalize (String path) {
        return apiClient.request(path).thenApply(
            response -> new ApiResponseProcessor(response).getParagraphStatistics()
        );
    }

    private TextResponse getTextResponse (List<ParagraphStatistics> paragraphStatistics) {
        TextResponse textResponse = new TextResponse();

        Map<String, Integer> totalWordCounts = new HashMap<>();
        Long timeSum = 0L;
        Integer sizeSum = 0;
        String mostFrequent = "";
        Integer mostFrequentCount = 0;
        for (ParagraphStatistics statistics : paragraphStatistics) {
            timeSum += statistics.getProcessingTime();
            sizeSum += statistics.getSize();
            for (Entry<String, Integer> wordCount : statistics.getWordCounts().entrySet()) {
                String word = wordCount.getKey();
                Integer newCount = totalWordCounts.getOrDefault(wordCount.getKey(), 0)
                        + wordCount.getValue();
                totalWordCounts.put(word, newCount);
                if (newCount > mostFrequentCount) {
                    mostFrequentCount = newCount;
                    mostFrequent = word;
                }
            }
        }

        textResponse.setAverageTime((double) timeSum / paragraphStatistics.size());
        textResponse.setAverageSize((double) sizeSum / paragraphStatistics.size());
        textResponse.setMostFrequent(mostFrequent);
        return textResponse;
    }

}
