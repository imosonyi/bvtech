package hu.imosonyi.bvtech.randomtext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Test;

import hu.imosonyi.bvtech.dto.ApiResponse;
import hu.imosonyi.bvtech.dto.ParagraphStatistics;

public class ApiResponseProcessorTest {

    @Test
    public void testProcessorShouldSplitParagraphs () {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setGeneratedParagraphs("<p>Paragraph no 1.</p>\r<p>Paragraph no 2.</p>\r");

        List<ParagraphStatistics> result = new ApiResponseProcessor(apiResponse).getParagraphStatistics();

        assertThat(result.size(), is(equalTo(2)));
    }

}
