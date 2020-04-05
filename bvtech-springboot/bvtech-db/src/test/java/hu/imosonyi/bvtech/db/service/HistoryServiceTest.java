package hu.imosonyi.bvtech.db.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import hu.imosonyi.bvtech.db.repository.AnalysisReportRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryServiceTest {

    @Autowired
    private HistoryService historyService;

    @MockBean
    private AnalysisReportRepository analysisReportRepository;
    
    @Test
    public void testGetHistoryShouldCallAnalysisReportRepository () {
        historyService.getHistory();

        verify(analysisReportRepository, times(1)).findTop10ByOrderByCreatedAtDesc();
    }
    
}
