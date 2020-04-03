package hu.imosonyi.bvtech.analyzer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.imosonyi.bvtech.analyzer.dto.TextRequest;
import hu.imosonyi.bvtech.analyzer.dto.TextResponse;
import hu.imosonyi.bvtech.analyzer.jms.AnalysisReportPublisher;
import hu.imosonyi.bvtech.analyzer.randomtext.TextResponseCalculator;

@Service
public class TextService {

    @Autowired
    private TextResponseCalculator calculator;

    @Autowired
    private AnalysisReportPublisher analysisReportPublisher;

    /**
     * TODO.
     * 
     * @param textRequest TODO.
     * @return
     */
    public TextResponse getStatistics (TextRequest textRequest) {
        TextResponse response = calculator.calculate(textRequest);
        analysisReportPublisher.send(response);
        return response;
    }

}
