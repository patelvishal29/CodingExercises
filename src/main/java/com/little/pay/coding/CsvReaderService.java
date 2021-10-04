package com.little.pay.coding;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.little.pay.coding.vo.UserInput;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvReaderService {

	private static final Logger logger = LoggerFactory.getLogger(CsvReaderService.class);
	
	public Reader getReader(String file) throws IOException{
		InputStream inputStream = CsvReaderService.class.getClassLoader().getResourceAsStream(file);
		if(inputStream == null) {
			throw new IOException("FileNotFound Exception");
		}
		return new InputStreamReader(inputStream);
	}

	public List<UserInput> parseCsvFile(String fileName) {
		List<UserInput> usersTrips = null;
		try {
			Reader reader = getReader(fileName);

			CsvToBean<UserInput> csvReader = new CsvToBeanBuilder(reader).withType(UserInput.class).withSeparator(',')
					.withIgnoreLeadingWhiteSpace(true).withIgnoreEmptyLine(true).build();

			usersTrips = csvReader.parse();
			
			usersTrips.stream().forEach(x->{
				
				logger.debug("userinput stopId={}  TapType={}  ", x.getStopId() , x.getTapType());
			});
			
		} catch (IOException e) {
			logger.error("error occured while reading userInput csv file", e);
		}
		return usersTrips;

	}
}
