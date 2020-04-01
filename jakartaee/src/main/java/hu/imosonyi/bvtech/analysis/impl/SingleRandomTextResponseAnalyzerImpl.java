package hu.imosonyi.bvtech.analysis.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import hu.imosonyi.bvtech.analysis.SingleParagraphAnalyzer;
import hu.imosonyi.bvtech.analysis.SingleRandomTextResponseAnalyzer;
import hu.imosonyi.bvtech.dto.RandomTextResponse;
import hu.imosonyi.bvtech.dto.SingleParagraphStatistics;
import hu.imosonyi.bvtech.dto.SingleRandomTextResponseStatistics;

@RequestScoped
public class SingleRandomTextResponseAnalyzerImpl implements SingleRandomTextResponseAnalyzer {

    private static final String DELIMITER = "\r";
    
    @Inject
    private SingleParagraphAnalyzer singleParagraphAnalyzer;
    
    @Override
    public SingleRandomTextResponseStatistics analyze (RandomTextResponse randomTextResponse) {
        SingleRandomTextResponseStatistics statistics = new SingleRandomTextResponseStatistics();
        String paragraphs = randomTextResponse.getGeneratedParagraphs();
        List<SingleParagraphStatistics> singleParagraphStatistics = analyzeParagraphs(paragraphs);
        statistics.setParagraphSizes(calculateSizes(singleParagraphStatistics));
        statistics.setWordCounts(calculateWordCounts(singleParagraphStatistics));
        return statistics;
    }

    private List<SingleParagraphStatistics> analyzeParagraphs (String paragraphs) {
        return Arrays.asList(paragraphs.split(DELIMITER))
                .stream()
                .map(paragraph -> singleParagraphAnalyzer.analyze(paragraph))
                .collect(Collectors.toList());
    }
    
    private List<Integer> calculateSizes (
            List<SingleParagraphStatistics> singleParagraphStatistics) {
        return singleParagraphStatistics
                .stream()
                .mapToInt(SingleParagraphStatistics::getSize)
                .boxed()
                .collect(Collectors.toList());
    }
    
    private Map<String, Integer> calculateWordCounts (
            List<SingleParagraphStatistics> singleParagraphStatistics) {
        Map<String, Integer> wordCounts = new HashMap<>();
        singleParagraphStatistics.forEach(statistics -> 
                statistics.getWordCounts().entrySet().forEach(entry ->
                        wordCounts.put(
                                entry.getKey(),
                                wordCounts.getOrDefault(entry.getKey(), 0) + entry.getValue()
                        )
                )
        );
        return wordCounts;
    }

}
