package hu.imosonyi.bvtech.db.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/betvictor")
public class HistoryController {
    
    @GetMapping("/history")
    public ResponseEntity<String> getHistory () {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

}
