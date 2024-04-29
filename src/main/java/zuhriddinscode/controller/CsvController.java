package zuhriddinscode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zuhriddinscode.domain.model.CsvData;
import zuhriddinscode.service.CsvService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/api/csv")
public class CsvController {

    @Autowired
    private CsvService csvService;

    @PostMapping("/upload")
    public List<CsvData> uploadAndSortCsv ( @RequestParam("file") MultipartFile file,
            @RequestParam(required = false, defaultValue = "numeric") String sortType )
            throws Exception {

        BufferedReader reader =
                new BufferedReader
                        (new InputStreamReader
                                (file.getInputStream()));
        List<CsvData> data = csvService.loadCsv(reader);

        if ("numeric".equals(sortType)) {
            return csvService.sortDataNumerically(data);
        } else {
            return csvService.sortDataAlphabetically(data);
        }
    }
}