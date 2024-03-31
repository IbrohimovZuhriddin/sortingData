package zuhriddinscode;

public class CsvData {
    private int city_code;
    private String city;

    public CsvData() {
    }

    public CsvData(int city_code, String city) {
        this.city_code = city_code;
        this.city = city;
    }

    public int getCity_code() {
        return city_code;
    }

    public void setCity_code(int city_code) {
        this.city_code = city_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}