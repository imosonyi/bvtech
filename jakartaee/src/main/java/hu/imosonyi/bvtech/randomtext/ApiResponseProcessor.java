package hu.imosonyi.bvtech.randomtext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import hu.imosonyi.bvtech.dto.ApiResponse;
import hu.imosonyi.bvtech.dto.ParagraphStatistics;

/**
 * Processes the responses from RandomText API. Divides the rensponse text into
 * single paragraphs and calculates the statistics for them.
 *
 * @author István Mosonyi
 */
public class ApiResponseProcessor {

    private static final String DELIMITER = "\r";

    private final List<ParagraphStatistics> paragraphStatistics;

    /**
     * Process RandomText API response.
     *
     * @param apiResponse RandomText API response.
     */
    public ApiResponseProcessor (ApiResponse apiResponse) {
        List<String> paragraphs = calculateParagraphs(apiResponse.getGeneratedParagraphs());
        paragraphStatistics = calculateParagraphStatistics(paragraphs);
    }

    /**
     * Get statistics for a single paragraph.
     *
     * @return Single paragraph statistics.
     */
    public List<ParagraphStatistics> getParagraphStatistics () {
        return paragraphStatistics;
    }

    private List<String> calculateParagraphs (String generatedParagraphs) {
        return Arrays.asList(generatedParagraphs.split(DELIMITER));
    }

    private List<ParagraphStatistics> calculateParagraphStatistics (List<String> paragraphs) {
        return paragraphs.stream()
                .map(paragraph -> new ParagraphAnalyzer(paragraph).getStatistics())
                .collect(Collectors.toList());
    }

}
