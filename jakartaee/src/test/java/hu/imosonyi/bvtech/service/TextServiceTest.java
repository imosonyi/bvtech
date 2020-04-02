package hu.imosonyi.bvtech.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import hu.imosonyi.bvtech.dao.AnalysisReportDao;
import hu.imosonyi.bvtech.dto.TextRequest;
import hu.imosonyi.bvtech.dto.TextResponse;
import hu.imosonyi.bvtech.model.AnalysisReport;
import hu.imosonyi.bvtech.service.impl.ApiServiceImpl;
import hu.imosonyi.bvtech.service.impl.TextServiceImpl;
import hu.imosonyi.bvtech.util.TextResponseToAnalysisReportConverter;

@RunWith(MockitoJUnitRunner.class)
public class TextServiceTest {

    @Mock
    private ApiServiceImpl apiService;

    @Mock
    private AnalysisReportDao analysisReportDao;

    @Mock
    private TextResponseToAnalysisReportConverter converter;

    @InjectMocks
    private TextService textService = new TextServiceImpl();

    @Test
    public void testGetStatisticsShouldCallApiService () {
        TextRequest request = new TextRequest();

        textService.getStatistics(request);

        verify(apiService, times(1)).analyze(request);
    }

    @Test
    public void testGetStatisticsShouldCallAnalysisReportDao () {
        TextRequest request = new TextRequest();
        TextResponse response = new TextResponse();
        AnalysisReport report = new AnalysisReport();
        when(apiService.analyze(request)).thenReturn(response);
        when(converter.convert(response)).thenReturn(report);

        textService.getStatistics(request);

        verify(analysisReportDao, times(1)).save(any(AnalysisReport.class));
    }

}
