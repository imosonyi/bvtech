package hu.imosonyi.bvtech.db.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hu.imosonyi.bvtech.db.dto.TextResponse;
import hu.imosonyi.bvtech.db.repository.AnalysisReportRepository;
import hu.imosonyi.bvtech.db.util.TextResponseToAnalysisReportConverter;

@Component
@EnableJms
public class AnalysisReportConsumer {

    @Autowired
    private AnalysisReportRepository analysisReportRepository;

    private TextResponseToAnalysisReportConverter converter =
            new TextResponseToAnalysisReportConverter();

    /**
     * TODO.
     * @param message TODO.
     */
    @JmsListener(destination = "bvtech-db")
    public void listener (String message) {
        try {
            TextResponse textResponse = new ObjectMapper().readValue(message, TextResponse.class);
            analysisReportRepository.save(converter.convert(textResponse));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
