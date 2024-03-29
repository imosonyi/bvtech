package hu.imosonyi.bvtech.analyzer.randomtext;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private TextResponseCalculator calculator;

    /**
     * Analyze single paragraph.
     *
     * @param paragraph Single paragraph from RandomText API.
     */
    public void analyze (String paragraph) {
        long start = System.currentTimeMillis();
        List<String> wordList = calculateWordList(paragraph);
        calculator.addSize(wordList.size());
        wordList.forEach(calculator::addWord);
        calculator.addTime(start);
    }

    private List<String> calculateWordList (String paragraph) {
        String paragraphWithoutHtml = paragraph.substring(P_START, paragraph.length() - P_END);
        return Arrays.asList(paragraphWithoutHtml.split(DELIMITER));
    }

}
