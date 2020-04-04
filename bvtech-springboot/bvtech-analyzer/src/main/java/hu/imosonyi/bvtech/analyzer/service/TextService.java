package hu.imosonyi.bvtech.analyzer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.imosonyi.bvtech.analyzer.dto.TextRequest;
import hu.imosonyi.bvtech.analyzer.dto.TextResponse;
import hu.imosonyi.bvtech.analyzer.jms.AnalysisReportPublisher;
import hu.imosonyi.bvtech.analyzer.randomtext.TextResponseCalculator;

/**
 * Service layer for handling the requests coming in /betvictor/text.
 *
 * @author István Mosonyi
 */
@Service
public class TextService {

    @Autowired
    private TextResponseCalculator calculator;

    @Autowired
    private AnalysisReportPublisher analysisReportPublisher;

    /**
     * Delegates the analysis calculation to {@link TextResponseCalculator} and stores the
     * result in the database.
     *
     * @param textRequest The /betvictor/text request to analyse.
     * @return Analysis report of the paragraphs.
     */
    public TextResponse getStatistics (TextRequest textRequest) {
        TextResponse response = calculator.calculate(textRequest);
        analysisReportPublisher.send(response);
        return response;
    }

}
