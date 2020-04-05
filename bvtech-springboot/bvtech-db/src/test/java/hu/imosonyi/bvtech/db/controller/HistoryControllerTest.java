package hu.imosonyi.bvtech.db.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import hu.imosonyi.bvtech.db.dto.TextResponse;
import hu.imosonyi.bvtech.db.service.HistoryService;

@RunWith(SpringRunner.class)
@WebMvcTest(HistoryController.class)
public class HistoryControllerTest {
 
    @Autowired
    private MockMvc mvc;

    @MockBean
    private HistoryService historyService;
    
    @Test
    public void testGetHistoryShouldReturnHistoryList () throws Exception {
        TextResponse response = new TextResponse();
        response.setMostFrequent("frequent");
        response.setAverageSize(1.0);
        response.setAverageTime(1.0);
        response.setTotalTime(1L);
        
        given(historyService.getHistory()).willReturn(Arrays.asList(response));
        
        mvc.perform(get("/betvictor/history").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].freq_word", is(response.getMostFrequent())))
                .andExpect(jsonPath("$[0].avg_paragraph_size", is(response.getAverageSize())))
                .andExpect(jsonPath("$[0].avg_paragraph_processing_time", is(response.getAverageTime())))
                .andExpect(jsonPath("$[0].total_processing_time", is(response.getTotalTime().intValue())));
    }

}
