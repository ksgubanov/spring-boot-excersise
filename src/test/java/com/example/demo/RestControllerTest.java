package com.example.demo;

import com.example.demo.repository.NaceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class RestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private NaceRepository repository;

    @Test
    public void givenNotExistingRecord_thenStatus202() throws Exception {
        mvc.perform(get("/nace/999")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    public void givenInvalidInputData_thenGetMessageNoException() throws Exception {
        Resource fileResource = new ClassPathResource("restControllerTest/invalid.csv");

        MockMultipartFile file = new MockMultipartFile("invalid.csv", fileResource.getFilename(),
            "text/csv", fileResource.getInputStream());


        mvc.perform(MockMvcRequestBuilders.multipart("/nace/upload")
            .file(file))
            .andExpect(status().isBadRequest()) // TODO: actually wrong
            .andDo(MockMvcResultHandlers.print());
    }
}
