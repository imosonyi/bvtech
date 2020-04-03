package hu.imosonyi.bvtech.analyzer.randomtext;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hu.imosonyi.bvtech.analyzer.dto.ApiResponse;

/**
 * Processes the responses from RandomText API. Divides the rensponse text into
 * single paragraphs and calculates the statistics for them.
 *
 * @author István Mosonyi
 */
public class ApiResponseProcessor {

    private static final String DELIMITER = "\r";

    @Autowired
    private ParagraphAnalyzer paragraphAnalyzer;

    /**
     * Process RandomText API response.
     *
     * @param apiResponse RandomText API response.
     */
    public void process (ApiResponse apiResponse) {
        List<String> paragraphs = splitParagraphs(apiResponse.getGeneratedParagraphs());
        calculateParagraphStatistics(paragraphs);
    }

    private List<String> splitParagraphs (String generatedParagraphs) {
        return Arrays.asList(generatedParagraphs.split(DELIMITER));
    }

    private void calculateParagraphStatistics (List<String> paragraphs) {
        paragraphs.forEach(paragraphAnalyzer::analyze);
    }

}
