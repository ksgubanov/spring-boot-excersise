package com.example.demo;

import com.example.demo.service.NaceService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NaceServiceTest {

    @Autowired
    NaceService naceService;

    @Test
    public void givenEmptyDataForPersistence_thenNoExceptionThrown() {
        MockMultipartFile file = new MockMultipartFile("empty", "empty.csv",
            "text/csv", "".getBytes());
            Assertions.assertDoesNotThrow(() -> naceService.saveAll(file));
    }

    @Test
    public void givenNullDataForPersistence_thenNoExceptionThrown() {
        Assertions.assertDoesNotThrow(() -> naceService.saveAll(null));
    }

}
