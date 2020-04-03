package hu.imosonyi.bvtech.analyzer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.imosonyi.bvtech.analyzer.dto.TextRequest;
import hu.imosonyi.bvtech.analyzer.dto.TextResponse;
import hu.imosonyi.bvtech.analyzer.service.TextService;

@RestController
@RequestMapping("/betvictor")
public class TextController {

    @Autowired
    private TextService textService;
    
    @GetMapping("/text")
    public ResponseEntity<TextResponse> getText (
            @RequestParam("p_start") Integer start,
            @RequestParam("p_end") Integer end,
            @RequestParam("w_count_min") Integer min,
            @RequestParam("w_count_max") Integer max) {
        TextRequest textRequest = new TextRequest(start, end, min, max);
        return new ResponseEntity<>(textService.getStatistics(textRequest), HttpStatus.OK);
    }

}
