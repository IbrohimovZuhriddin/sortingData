package zuhriddinscode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import zuhriddinscode.domain.model.CsvData;
import zuhriddinscode.service.CsvService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ApplicationTests {

	@Test
	public void testSortDataNumerically() throws IOException {

		CsvService csvServic = new CsvService();
		BufferedReader reader = new BufferedReader
				(new InputStreamReader(new ClassPathResource("myFile0.csv")
				.getInputStream()));

		List<CsvData> data = csvServic.loadCsv(reader);
		List<CsvData> sortedData = csvServic.sortDataNumerically(data);
		assertTrue(testSortDataByCityCode(sortedData));

	}

	@Test
	public void testsortDataAlphabetically() throws IOException {
		CsvService csvServic = new CsvService();

		BufferedReader reader =
				new BufferedReader
						(new InputStreamReader
								(new ClassPathResource
										("myFile0.csv").getInputStream()));

		List<CsvData> data = csvServic.loadCsv(reader);
		List<CsvData> sortedData = csvServic.sortDataAlphabetically(data);
		assertTrue(testSortDataByCityName(sortedData));
	}

	private boolean testSortDataByCityCode ( List<CsvData> data) {
		for (int i = 0; i < data.size() - 1; i++) {
			if (data.get(i).getCity_code() > data.get(i + 1).getCity_code()) {
				return false;
			}
		}
		return true;
	}

	private boolean testSortDataByCityName(List<CsvData> data) {
		for (int i = 0; i < data.size() - 1; i++) {
			if (data.get(i).getCity().compareTo(data.get(i + 1).getCity()) > 0) {
				return false;
			}
		}
		return true;
	}
}