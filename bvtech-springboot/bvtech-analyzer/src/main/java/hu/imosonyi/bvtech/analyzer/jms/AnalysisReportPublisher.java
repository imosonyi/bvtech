package hu.imosonyi.bvtech.analyzer.jms;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hu.imosonyi.bvtech.analyzer.dto.TextResponse;

/**
 * Sends the analysis report to the db microservice.
 *
 * @author István Mosonyi
 */
@Service
public class AnalysisReportPublisher {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * Sends the analysis report in JSON string format via JMS.
     *
     * @param textResponse Analysis report to send.
     */
    public void send(TextResponse textResponse) {
        try {
            jmsTemplate.convertAndSend(queue, new ObjectMapper().writeValueAsString(textResponse));
        } catch (JmsException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
