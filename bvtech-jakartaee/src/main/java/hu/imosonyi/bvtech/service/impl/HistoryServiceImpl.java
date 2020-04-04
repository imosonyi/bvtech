package hu.imosonyi.bvtech.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import hu.imosonyi.bvtech.dao.AnalysisReportDao;
import hu.imosonyi.bvtech.dto.TextResponse;
import hu.imosonyi.bvtech.service.HistoryService;
import hu.imosonyi.bvtech.util.TextResponseToAnalysisReportConverter;

/**
 * Implements the {@link HistoryService} interface.
 *
 * @author István Mosonyi
 */
@RequestScoped
public class HistoryServiceImpl implements HistoryService {

    private static final Integer DEFAULT_LIMIT = 10;

    @Inject
    private AnalysisReportDao analysisReportDao;

    private TextResponseToAnalysisReportConverter converter =
            new TextResponseToAnalysisReportConverter();

    @Override
    public List<TextResponse> getHistory () {
        return analysisReportDao.findLastNReports(DEFAULT_LIMIT)
                .stream()
                .map(converter::revert)
                .collect(Collectors.toList());
    }

}
