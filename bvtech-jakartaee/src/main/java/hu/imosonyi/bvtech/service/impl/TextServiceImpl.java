package hu.imosonyi.bvtech.service.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import hu.imosonyi.bvtech.dao.AnalysisReportDao;
import hu.imosonyi.bvtech.dto.TextRequest;
import hu.imosonyi.bvtech.dto.TextResponse;
import hu.imosonyi.bvtech.service.TextService;
import hu.imosonyi.bvtech.util.TextResponseToAnalysisReportConverter;

/**
 * Implements the {@link TextService} interface.
 *
 * @author István Mosonyi
 */
@RequestScoped
public class TextServiceImpl implements TextService {

    @Inject
    private ApiServiceImpl apiService;

    @Inject
    private AnalysisReportDao analysisReportDao;

    private TextResponseToAnalysisReportConverter converter =
            new TextResponseToAnalysisReportConverter();

    @Override
    public TextResponse getStatistics (TextRequest textRequest) {
        TextResponse textResponse = apiService.analyze(textRequest);
        analysisReportDao.save(converter.convert(textResponse));
        return textResponse;
    }

}
