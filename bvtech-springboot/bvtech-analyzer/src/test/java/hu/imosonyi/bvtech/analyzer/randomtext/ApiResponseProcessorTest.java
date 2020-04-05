package hu.imosonyi.bvtech.analyzer.randomtext;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import hu.imosonyi.bvtech.analyzer.dto.ApiResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiResponseProcessorTest {

    @Autowired
    private ApiResponseProcessor apiResponseProcessor;

    @MockBean
    private ParagraphAnalyzer paragraphAnalyzer;

    @Test
    public void testProcessorShouldSplitParagraphs () {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setGeneratedParagraphs("<p>Paragraph no 1.</p>\r<p>Paragraph no 2.</p>\r");

        apiResponseProcessor.process(apiResponse);

        verify(paragraphAnalyzer, times(1)).analyze("<p>Paragraph no 1.</p>");
        verify(paragraphAnalyzer, times(1)).analyze("<p>Paragraph no 2.</p>");
    }

}
