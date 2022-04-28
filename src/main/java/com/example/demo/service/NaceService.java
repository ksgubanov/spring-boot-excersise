package com.example.demo.service;

import com.example.demo.csv.NaceCSVParser;
import com.example.demo.model.NaceRecord;
import com.example.demo.repository.NaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class NaceService {

    private final NaceRepository naceRepository;

    public NaceService(NaceRepository naceRepository) {
        this.naceRepository = naceRepository;
    }

    public void saveAll(MultipartFile file) throws IOException {
        if (file != null) {
            naceRepository.saveAll(NaceCSVParser.parceCsv(file.getInputStream()));
        }
    }

    public NaceRecord getNaceRecordByOrder(Long order) {
        return naceRepository.findByOrderId(order);
    }

}
