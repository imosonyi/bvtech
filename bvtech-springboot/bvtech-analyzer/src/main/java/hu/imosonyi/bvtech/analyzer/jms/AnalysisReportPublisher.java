package hu.imosonyi.bvtech.analyzer.jms;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hu.imosonyi.bvtech.analyzer.dto.TextResponse;

@Service
public class AnalysisReportPublisher {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;
    
    /**
     * TODO.
     * @param textResponse TODO.
     */
    public void send(TextResponse textResponse) {
        try {
            jmsTemplate.convertAndSend(queue, new ObjectMapper().writeValueAsString(textResponse));
        } catch (JmsException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    
}
