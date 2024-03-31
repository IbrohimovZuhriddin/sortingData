package zuhriddinscode;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.util.Comparator;
import java.util.List;

@Service
public class CsvService {

    public List<CsvData> loadCsv(BufferedReader reader) {
        return new CsvToBeanBuilder<CsvData>(reader)
                .withType(CsvData.class)
                .build()
                .parse();
    }

    public List<CsvData> sortDataNumerically(List<CsvData> data) {
        data.sort(Comparator.comparingInt(CsvData::getCity_code));
        return data;
    }

    public List<CsvData> sortDataAlphabetically(List<CsvData> data) {
        data.sort(Comparator.comparing(CsvData::getCity));
        return data;
    }
}