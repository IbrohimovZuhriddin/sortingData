package zuhriddinscode.domain.model;

import lombok.Data;

@Data
public class CsvData {
    private int city_code;
    private String city;

    public CsvData() {
    }

    public CsvData(int city_code, String city) {
        this.city_code = city_code;
        this.city = city;
    }
}