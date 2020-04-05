package hu.imosonyi.bvtech.analyzer.service;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import hu.imosonyi.bvtech.analyzer.dto.TextRequest;
import hu.imosonyi.bvtech.analyzer.dto.TextResponse;
import hu.imosonyi.bvtech.analyzer.jms.AnalysisReportPublisher;
import hu.imosonyi.bvtech.analyzer.randomtext.TextResponseCalculator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TextServiceTest {

    @Autowired
    private TextService textService;

    @MockBean
    private TextResponseCalculator calculator;

    @MockBean
    private AnalysisReportPublisher analysisReportPublisher;

    @Test
    public void testGetStatisticsShouldCallTextResponseCalculator () {
        TextRequest textRequest = new TextRequest(10, 20, 30, 40);

        textService.getStatistics(textRequest);

        verify(calculator, times(1)).calculate(textRequest);
    }

    @Test
    public void testGetStatisticsShouldCallAnalysisReportPublisher () {
        TextRequest textRequest = new TextRequest(10, 20, 30, 40);
        TextResponse response = new TextResponse();

        given(calculator.calculate(textRequest)).willReturn(response);

        textService.getStatistics(textRequest);

        verify(analysisReportPublisher, times(1)).send(response);
    }

}
