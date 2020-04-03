package hu.imosonyi.bvtech.analyzer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/betvictor")
public class TextController {

    @GetMapping("/text")
    public ResponseEntity<String> getText (
            @RequestParam("p_start") Integer start,
            @RequestParam("p_end") Integer end,
            @RequestParam("w_count_min") Integer min,
            @RequestParam("w_count_max") Integer max) {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

}
