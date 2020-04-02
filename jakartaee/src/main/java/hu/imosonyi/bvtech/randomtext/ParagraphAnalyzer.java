package hu.imosonyi.bvtech.randomtext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.imosonyi.bvtech.dto.ParagraphStatistics;

public class ParagraphAnalyzer {

    // "<p>".length()
    private static final Integer P_START = 3;

    // ".</p>".length()
    private static final Integer P_END = 5;

    private static final String DELIMITER = " ";

    private final ParagraphStatistics statistics;

    /**
     * TODO.
     * @param paragraph TODO.
     */
    public ParagraphAnalyzer (String paragraph) {
        final long start = System.currentTimeMillis();
        statistics = new ParagraphStatistics();
        List<String> wordList = calculateWordList(paragraph);
        statistics.setSize(wordList.size());
        statistics.setWordCounts(calculateWordCounts(wordList));
        final long end = System.currentTimeMillis();
        statistics.setProcessingTime(end - start);
    }
    
    public ParagraphStatistics getStatistics () {
        return statistics;
    }

    private List<String> calculateWordList (String paragraph) {
        String paragraphWithoutHtml = paragraph.substring(P_START, paragraph.length() - P_END);
        return Arrays.asList(paragraphWithoutHtml.split(DELIMITER));
    }

    private Map<String, Integer> calculateWordCounts (List<String> wordList) {
        Map<String, Integer> wordCounts = new HashMap<>();
        wordList.forEach(word -> wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1));
        return wordCounts;
    }

}
