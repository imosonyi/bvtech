package hu.imosonyi.bvtech.db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.imosonyi.bvtech.db.dto.TextResponse;
import hu.imosonyi.bvtech.db.service.HistoryService;

@RestController
@RequestMapping("/betvictor")
public class HistoryController {
    
    @Autowired
    private HistoryService historyService;
    
    @GetMapping("/history")
    @CrossOrigin("*")
    public ResponseEntity<List<TextResponse>> getHistory () {
        return new ResponseEntity<>(historyService.getHistory(), HttpStatus.OK);
    }

}
