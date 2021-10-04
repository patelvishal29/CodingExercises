package com.little.pay.coding;

import static com.little.pay.coding.util.FileReaderConstant.USER_INPUT_FILE;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.little.pay.coding.vo.UserOutput;

@SpringBootApplication
public class CodingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingApplication.class, args);

		CsvReaderService csvReaderService = new CsvReaderService();
		CalcaulateUserTrips calculateTrips = new CalcaulateUserTrips();
		List<UserOutput> userOutput = calculateTrips.calculateTrips(csvReaderService.parseCsvFile(USER_INPUT_FILE));
		CsvWriterService csvWriterService = new CsvWriterService();
		csvWriterService.writeCsvFromBean(userOutput);
	}

}
