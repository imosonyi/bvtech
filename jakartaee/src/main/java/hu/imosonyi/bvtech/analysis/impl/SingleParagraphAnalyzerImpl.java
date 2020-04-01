package hu.imosonyi.bvtech.analysis.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import hu.imosonyi.bvtech.analysis.SingleParagraphAnalyzer;
import hu.imosonyi.bvtech.dto.SingleParagraphStatistics;

@RequestScoped
public class SingleParagraphAnalyzerImpl implements SingleParagraphAnalyzer {

    // "<p>".length()
    private static final Integer P_START = 3;

    // ".</p>".length()
    private static final Integer P_END = 5;

    private static final String DELIMITER = " ";

    @Override
    public SingleParagraphStatistics analyze (String paragraph) {
        List<String> wordList = calculateWordList(paragraph);
        Integer size = wordList.size();
        Map<String, Integer> wordCounts = calculateWordCounts(wordList);
        return new SingleParagraphStatistics(wordCounts, size);
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
