package hu.imosonyi.bvtech.analyzer.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import hu.imosonyi.bvtech.analyzer.dto.TextRequest;
import hu.imosonyi.bvtech.analyzer.dto.TextResponse;
import hu.imosonyi.bvtech.analyzer.service.TextService;

@RunWith(SpringRunner.class)
@WebMvcTest(TextController.class)
public class TextControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TextService textService;

    @Test
    public void testGetHistoryShouldReturnHistoryList () throws Exception {
        TextResponse response = generateTextResponse();
        TextRequest request = new TextRequest(10, 20, 30, 40);

        given(textService.getStatistics(request)).willReturn(response);

        mvc.perform(get("/betvictor/text").accept(MediaType.APPLICATION_JSON)
                .queryParam("p_start", "10")
                .queryParam("p_end", "20")
                .queryParam("w_count_min", "30")
                .queryParam("w_count_max", "40"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.freq_word", is(response.getMostFrequent())))
                .andExpect(jsonPath("$.avg_paragraph_size", is(response.getAverageSize())))
                .andExpect(jsonPath("$.avg_paragraph_processing_time", is(response.getAverageTime())))
                .andExpect(jsonPath("$.total_processing_time", is(response.getTotalTime().intValue())));
    }

    private TextResponse generateTextResponse () {
        TextResponse response = new TextResponse();
        response.setMostFrequent("frequent");
        response.setAverageSize(1.0);
        response.setAverageTime(1.0);
        response.setTotalTime(1L);
        return response;
    }

}
