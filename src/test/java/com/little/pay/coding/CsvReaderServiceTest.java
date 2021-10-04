package com.little.pay.coding;

import static com.little.pay.coding.util.FileReaderConstant.USER_INPUT_FILE;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.little.pay.coding.vo.UserInput;

public class CsvReaderServiceTest {

	@MockBean
	private CsvReaderService csvReaderService;

	@BeforeEach
	public void init() {
		csvReaderService = new CsvReaderService();
	}
	

	

	@Test
	void readCsvFile__withAllDetail_successfully_() {
		List<UserInput> userList = csvReaderService.parseCsvFile(USER_INPUT_FILE);
		UserInput userInput = userList.get(0);

		Assertions.assertEquals(userList.size(), 2);
		Assertions.assertEquals("Bus37", userInput.getBusId().trim());
		Assertions.assertEquals("ON", userInput.getTapType().trim());
		Assertions.assertEquals("55003312", userInput.getPan().trim());
		Assertions.assertEquals("Stop1", userInput.getStopId().trim());
		Assertions.assertEquals("1", userInput.getId().trim());
		Assertions.assertEquals("Company1", userInput.getCompanyId().trim());
		Assertions.assertEquals("22-01-2018 13:10", userInput.getDateTime().trim());
		
	}
	
	@Test
	void readCsvFile__fileNotFound_returnNull() {
		List<UserInput> userList = csvReaderService.parseCsvFile("user_input1.csv");
		Assertions.assertNull(userList);
	}
	
	@Test
	void readCsvFile__fileNotFound_exception_() throws IOException {
		Assertions.assertThrows(IOException.class, ()->{
			csvReaderService.getReader("user_input1.csv");
		},"FileNotFound Exception");
	}

	

	
}
