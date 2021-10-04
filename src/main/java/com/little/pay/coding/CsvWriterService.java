package com.little.pay.coding;

import static com.little.pay.coding.util.FileReaderConstant.USER_OUTPUT_FILE;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.little.pay.coding.vo.UserOutput;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvWriterService {
	
	private static final Logger logger = LoggerFactory.getLogger(CsvWriterService.class);
	
	public void writeCsvFromBean(List<UserOutput> userTrips)  {
		File file = new File(USER_OUTPUT_FILE);
	    try {
	    	 Writer writer  = new FileWriter(file);

	 	    StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
	 	       .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
	 	       .build();

	 	   beanToCsv.write(userTrips);
	 	   writer.close();
		} catch (Exception e) {
			logger.error("error occured while writing userourput file", e);
			
		}
	   
	}
	
	
}


