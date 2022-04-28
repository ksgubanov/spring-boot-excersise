package com.example.demo.contoller;

import com.example.demo.csv.NaceCSVParser;
import com.example.demo.model.NaceRecord;
import com.example.demo.service.NaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class NaceController {
    private final NaceService naceService;

    public NaceController(NaceService naceService) {
        this.naceService = naceService;
    }

    @GetMapping("/nace/{order}")
    public NaceRecord getNaceRecordByOrder(@PathVariable Long order) {
        return naceService.getNaceRecordByOrder(order);
    }

    @PostMapping("/nace/upload")
    public ResponseEntity<String> uploadNaceCsv(@RequestParam("csv") MultipartFile csvFile) throws IOException {
        if (NaceCSVParser.isValidFormat(csvFile)) {
            naceService.saveAll(csvFile);
        }

        return ResponseEntity.accepted().build();
    }
}
