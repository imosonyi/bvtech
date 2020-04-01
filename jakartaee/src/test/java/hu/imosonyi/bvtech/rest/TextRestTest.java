package hu.imosonyi.bvtech.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import hu.imosonyi.bvtech.dto.ParagraphGenerationInfo;
import hu.imosonyi.bvtech.dto.RandomParagraphsStatistics;
import hu.imosonyi.bvtech.rest.impl.TextRestImpl;
import hu.imosonyi.bvtech.service.TextService;

@RunWith(MockitoJUnitRunner.class)
public class TextRestTest extends AbstractRestTest {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextRest textRest = new TextRestImpl();

    @Test
    public void testGetTextShouldCallTextService () {
        when(Response.ok()).thenReturn(responseBuilder);
        when(textService.getRandomParagraphsStatistics(any())).thenReturn(new RandomParagraphsStatistics());
        when(responseBuilder.entity(any(RandomParagraphsStatistics.class))).thenReturn(responseBuilder);
        ParagraphGenerationInfo paragraphGenerationInfo = new ParagraphGenerationInfo();

        textRest.getText(paragraphGenerationInfo);

        verify(textService, times(1)).getRandomParagraphsStatistics(paragraphGenerationInfo);
    }

}
