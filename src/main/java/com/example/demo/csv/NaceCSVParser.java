package com.example.demo.csv;

import com.example.demo.model.NaceRecord;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.DataFormatException;

public class NaceCSVParser {

    public static boolean isValidFormat(MultipartFile csvData) {
        return "text/csv".equals(csvData.getContentType());
    }

    public static List<NaceRecord> parceCsv(InputStream csvStream) throws IOException {

        List<NaceRecord> naces = new ArrayList<>();

        try (BufferedReader csvReader = new BufferedReader(new InputStreamReader(csvStream));
             CSVParser csvParser = new CSVParser(csvReader, CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {


            Iterable<CSVRecord> records = csvParser.getRecords();
            for (CSVRecord r : records) {
                naces.add(createNaceFromCsvRecord(r));
            }
        }

        return naces;
    }

    private static NaceRecord createNaceFromCsvRecord(CSVRecord r) {
        return new NaceRecord(
            Long.parseLong(r.get("Order")),
            Integer.parseInt(r.get("Level")),
            r.get("Code"),
            r.get("Parent"),
            r.get("Description"),
            r.get("This item includes"),
            r.get("This item also includes"),
            r.get("Rulings"),
            r.get("This item excludes"),
            r.get("Reference to ISIC Rev. 4"));
    }

}
