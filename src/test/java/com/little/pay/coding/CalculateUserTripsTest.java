package com.little.pay.coding;

import static com.little.pay.coding.util.FileReaderConstant.STOP_ONE;
import static com.little.pay.coding.util.FileReaderConstant.STOP_THREE;
import static com.little.pay.coding.util.FileReaderConstant.STOP_TWO;
import static com.little.pay.coding.util.FileReaderConstant.TAP_OFF;
import static com.little.pay.coding.util.FileReaderConstant.TAP_ON;
import static com.little.pay.coding.util.FileReaderConstant.TRIP_STATUS_CANCEL;
import static com.little.pay.coding.util.FileReaderConstant.TRIP_STATUS_COMPLETE;
import static com.little.pay.coding.util.FileReaderConstant.TRIP_STATUS_INCOMPLETE;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.little.pay.coding.vo.UserInput;
import com.little.pay.coding.vo.UserOutput;

public class CalculateUserTripsTest {

	@MockBean
	private CalcaulateUserTrips calculateUser;

	@BeforeEach
	public void init() {
		calculateUser = new CalcaulateUserTrips();
	}
	/*
	 * @Test void lambdaExpressions() { assertTrue(Stream.of(1, 2, 3) .stream()
	 * .mapToInt(i -> i) .sum() > 5, () -> "Sum should be greater than 5"); }
	 */

	@Test
	void groupAssertions() {
		int[] numbers = { 0, 1, 2, 3, 4 };
		Assertions.assertEquals(5, 5);
	}

	@Test
	void calculateTrips_return_CompelteStatus_andCharges() {
		List<UserOutput> user = calculateUser.calculateTrips(getUserTrip());
		UserOutput userOutput = user.get(0);

		Assertions.assertEquals("3.25", userOutput.getChargeAmount());
		Assertions.assertEquals(TRIP_STATUS_COMPLETE, userOutput.getStatus());

	}

	@Test
	void calculateTrips_return_incompleteStatus_maxCharge() {
		List<UserInput> list = new ArrayList<>();
		list.add(getUserOne());

		List<UserOutput> user = calculateUser.calculateTrips(list);
		UserOutput userOutput = user.get(0);

		Assertions.assertEquals("7.30", userOutput.getChargeAmount());
		Assertions.assertEquals(TRIP_STATUS_INCOMPLETE, userOutput.getStatus());

	
	}
	
	@Test
	void calculateTrips_return_incompleteStatus_midCharge() {
		List<UserInput> list = new ArrayList<>();
		list.add(getUserTwo());

		List<UserOutput> user = calculateUser.calculateTrips(list);
		UserOutput userOutput = user.get(0);

		Assertions.assertEquals("5.50", userOutput.getChargeAmount());
		Assertions.assertEquals(TRIP_STATUS_INCOMPLETE, userOutput.getStatus());

	}
	
	@Test
	void calculateTrips_return_cancelStatus_noCharge() {
		List<UserInput> list = new ArrayList<>();
		
		UserInput userTwo = getUserTwo();
		userTwo.setStopId(STOP_ONE);
		
		list.add(getUserOne());
		list.add(userTwo);
		
		List<UserOutput> user = calculateUser.calculateTrips(list);
		UserOutput userOutput = user.get(0);

		Assertions.assertEquals("0.0", userOutput.getChargeAmount());
		Assertions.assertEquals(TRIP_STATUS_CANCEL, userOutput.getStatus());

	}
	
	@Test
	void calculateTrips_return_CompelteStatus_maxCharges() {
		List<UserInput> list = new ArrayList<>();
		
		UserInput userTwo = getUserTwo();
		userTwo.setStopId(STOP_THREE);
		
		list.add(getUserOne());
		list.add(userTwo);
		List<UserOutput> user = calculateUser.calculateTrips(list);
		UserOutput userOutput = user.get(0);

		Assertions.assertEquals("7.30", userOutput.getChargeAmount());
		Assertions.assertEquals(TRIP_STATUS_COMPLETE, userOutput.getStatus());

	}
	
	@Test
	void calculateTrips_return_CompelteStatus_midCharges() {
		List<UserInput> list = new ArrayList<>();
		UserInput userOne = getUserOne();
		userOne.setStopId(STOP_TWO);
		
		UserInput userTwo = getUserTwo();
		userTwo.setStopId(STOP_THREE);
		
		list.add(userOne);
		list.add(userTwo);
		List<UserOutput> user = calculateUser.calculateTrips(list);
		UserOutput userOutput = user.get(0);

		Assertions.assertEquals("5.50", userOutput.getChargeAmount());
		Assertions.assertEquals(TRIP_STATUS_COMPLETE, userOutput.getStatus());

	}

	private List<UserInput> getUserTrip() {
		List<UserInput> list = new ArrayList<>();
		list.add(getUserOne());
		list.add(getUserTwo());
		return list;
	}

	private UserInput getUserOne() {
		UserInput userOne = new UserInput();
		userOne.setId("1");
		userOne.setStopId(STOP_ONE);
		userOne.setTapType(TAP_ON);
		userOne.setBusId("Bus37");
		userOne.setCompanyId("Company1");
		userOne.setPan("PAN1");
		return userOne;
	}

	private UserInput getUserTwo() {
		UserInput userTwo = new UserInput();
		userTwo.setId("2");
		userTwo.setStopId(STOP_TWO);
		userTwo.setTapType(TAP_OFF);
		userTwo.setBusId("Bus37");
		userTwo.setCompanyId("Company1");
		userTwo.setPan("PAN1");
		return userTwo;
	}
}
