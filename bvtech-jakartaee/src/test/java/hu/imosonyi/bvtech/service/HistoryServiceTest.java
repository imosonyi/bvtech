package hu.imosonyi.bvtech.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import hu.imosonyi.bvtech.dao.AnalysisReportDao;
import hu.imosonyi.bvtech.service.impl.HistoryServiceImpl;
import hu.imosonyi.bvtech.util.TextResponseToAnalysisReportConverter;

@RunWith(MockitoJUnitRunner.class)
public class HistoryServiceTest {

    @Mock
    private AnalysisReportDao analysisReportDao;

    @Mock
    private TextResponseToAnalysisReportConverter converter;

    @InjectMocks
    private HistoryService historyService = new HistoryServiceImpl();

    @Test
    public void testGetHistoryShouldCallAnalysisReportDao () {
        historyService.getHistory();

        verify(analysisReportDao, times(1)).findLastNReports(10);
    }

}
