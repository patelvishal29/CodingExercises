package com.little.pay.coding;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.little.pay.coding.vo.UserOutput;
import com.opencsv.bean.StatefulBeanToCsv;

public class CsvWriterServiceTest {

	@MockBean
	private CsvWriterService csvWriterService;
	@Mock
	StatefulBeanToCsv beanToCsv;
	
	
	@BeforeEach
	public void init() {
		csvWriterService = new CsvWriterService();
		
	}
	

	

	@Test
	void readCsvFile__withAllDetail_successfully_() {
		
		csvWriterService.writeCsvFromBean(getUserTrip());
		
		verify(beanToCsv, times(1)); 
		

		
		
	}
	
	private List<UserOutput> getUserTrip() {
		List<UserOutput> list = new ArrayList<>();
		list.add(getUserOne());
		
		return list;
	}

	private UserOutput getUserOne() {
		UserOutput userOne = new UserOutput();
		
		userOne.setBusId("Bus37");
		userOne.setCompanyId("Company1");
		userOne.setPan("PAN1");
		return userOne;
	}
	
	
	

	
}
