package hu.imosonyi.bvtech.db.jms;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import hu.imosonyi.bvtech.db.model.AnalysisReport;
import hu.imosonyi.bvtech.db.repository.AnalysisReportRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnalysisReportConsumerTest {
    
    @Autowired
    private AnalysisReportConsumer analysisReportConsumer;
    
    @MockBean
    private AnalysisReportRepository analysisReportRepository;
    
    @Test
    public void testReceiveShouldCallAnalysisReportRepository () {
        String response = "{\"freq_word\":\"frequent\",\"avg_paragraph_size\":1.0,\"avg_paragraph_processing_time\":1.0,\"total_processing_time\":1}";
        AnalysisReport expected = new AnalysisReport();
        expected.setAverageParagraphProcessingTime(1.0);
        expected.setAverageParagraphSize(1.0);
        expected.setMostFrequentWord("frequent");
        expected.setTotalProcessingTime(1L);
        
        analysisReportConsumer.receive(response);

        verify(analysisReportRepository, times(1)).save(expected);
    }

}
