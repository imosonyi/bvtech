package hu.imosonyi.bvtech.analyzer.jms;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.jms.Queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import hu.imosonyi.bvtech.analyzer.dto.TextResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnalysisReportPublisherTest {

    @Autowired
    private AnalysisReportPublisher analysisReportPublisher;

    @MockBean
    private Queue queue;

    @MockBean
    private JmsTemplate jmsTemplate;

    @Test
    public void testSendShouldCallJmsTemplate () {
        TextResponse response = new TextResponse();
        response.setAverageSize(1.0);
        response.setAverageTime(1.0);
        response.setMostFrequent("frequent");
        response.setTotalTime(1L);
        String expected = "{\"freq_word\":\"frequent\",\"avg_paragraph_size\":1.0,\"avg_paragraph_processing_time\":1.0,\"total_processing_time\":1}";

        analysisReportPublisher.send(response);

        verify(jmsTemplate, times(1)).convertAndSend(queue, expected);
    }

}
