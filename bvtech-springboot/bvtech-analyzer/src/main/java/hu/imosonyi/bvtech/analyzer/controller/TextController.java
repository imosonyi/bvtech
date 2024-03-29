package hu.imosonyi.bvtech.analyzer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.imosonyi.bvtech.analyzer.dto.TextRequest;
import hu.imosonyi.bvtech.analyzer.dto.TextResponse;
import hu.imosonyi.bvtech.analyzer.service.TextService;

/**
 * Rest endpoint /betvictor/text.
 *
 * @author István Mosonyi
 */
@RestController
@RequestMapping("/betvictor")
public class TextController {

    @Autowired
    private TextService textService;

    /**
     * Makes all the necessary requests to the RandomText API and analyzes the
     * the responses. It is going to make a request for every
     * p_start <= p <= p_end with the specified word count min and max.
     * Example request:
     * /betvictor/text?p_start=1&p_end=100&w_count_min=1&w_count_max=25
     * Example response:
     * {
     *   "freq_word": "frequent",
     *   "avg_paragraph_size": 11.2321,
     *   "avg_paragraph_processing_time": 1.254,
     *   "total_processing_time": 3566*
     * }
     * @param start Start number of paragraphs.
     * @param end Last number of paragraphs.
     * @param min Minimum word count in paragraphs.
     * @param max Maximum word count in paragraphs.
     * @return Analysis results.
     */
    @GetMapping("/text")
    @CrossOrigin("*")
    public ResponseEntity<TextResponse> getText (
            @RequestParam("p_start") Integer start,
            @RequestParam("p_end") Integer end,
            @RequestParam("w_count_min") Integer min,
            @RequestParam("w_count_max") Integer max) {
        TextRequest textRequest = new TextRequest(start, end, min, max);
        return new ResponseEntity<>(textService.getStatistics(textRequest), HttpStatus.OK);
    }

}
