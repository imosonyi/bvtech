package hu.imosonyi.bvtech.randomtext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.imosonyi.bvtech.dto.ParagraphStatistics;

/**
 * Analyzes a single paragraph from RandomText API. Trims the HTML tags,
 * calculates the word counts and the size of the paragraph.
 *
 * @author István Mosonyi
 */
public class ParagraphAnalyzer {

    private static final Integer P_START = "<p>".length();

    private static final Integer P_END = ".</p>".length();

    private static final String DELIMITER = " ";

    private final ParagraphStatistics statistics;

    /**
     * Analyze single paragraph.
     *
     * @param paragraph Single paragraph from RandomText API.
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

    /**
     * Get the analysis result of a single paragraph.
     *
     * @return Statistics for a single paragraph.
     */
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
