package com.little.pay.coding;

import static com.little.pay.coding.util.FileReaderConstant.STOP_ONE;
import static com.little.pay.coding.util.FileReaderConstant.STOP_THREE;
import static com.little.pay.coding.util.FileReaderConstant.STOP_TWO;
import static com.little.pay.coding.util.FileReaderConstant.TAP_OFF;
import static com.little.pay.coding.util.FileReaderConstant.TAP_ON;
import static com.little.pay.coding.util.FileReaderConstant.TRIP_CANCEL_AMOUNT;
import static com.little.pay.coding.util.FileReaderConstant.TRIP_MAX_AMOUNT;
import static com.little.pay.coding.util.FileReaderConstant.TRIP_MID_AMOUNT;
import static com.little.pay.coding.util.FileReaderConstant.TRIP_MIN_AMOUNT;
import static com.little.pay.coding.util.FileReaderConstant.TRIP_STATUS_CANCEL;
import static com.little.pay.coding.util.FileReaderConstant.TRIP_STATUS_COMPLETE;
import static com.little.pay.coding.util.FileReaderConstant.TRIP_STATUS_INCOMPLETE;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.little.pay.coding.vo.UserInput;
import com.little.pay.coding.vo.UserOutput;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalcaulateUserTrips {

	private static final Logger logger = LoggerFactory.getLogger(CalcaulateUserTrips.class);

	public List<UserOutput> calculateTrips(List<UserInput> trips) {
		List<UserOutput> resultRecord = new ArrayList<>();
		UserOutput userOutput = new UserOutput();
		UserInput userOne;
		UserInput userTwo;
		String status = null;
		String chargeAmount = null;
		try {
			if (!CollectionUtils.isEmpty(trips) && trips.size() == 2) {
				userOne = trips.get(0);
				userTwo = trips.get(1);
				
				/*
				 * 
				 * calculate  the complete trip detail while comparing below condition
				 * 1)stopId and tapType  will be  different 
				 * 2) Pan detail must be same
				 * 
				 * */
				if (userOne.getPan().endsWith(userTwo.getPan()) && (userOne.getTapType().equals(TAP_ON))
						&& (userTwo.getTapType().equals(TAP_OFF))
						&& (!userOne.getStopId().equals(userTwo.getStopId()))) {

					status = TRIP_STATUS_COMPLETE; // "Completed";
					if ((userOne.getStopId().trim().equals(STOP_ONE) && userTwo.getStopId().trim().equals(STOP_TWO))
							|| (userOne.getStopId().trim().equals(STOP_TWO)
									&& userTwo.getStopId().trim().equals(STOP_ONE))) {
						chargeAmount = TRIP_MIN_AMOUNT;

					} else if ((userOne.getStopId().trim().equals(STOP_TWO)
							&& userTwo.getStopId().trim().equals(STOP_THREE))
							|| (userOne.getStopId().trim().equals(STOP_THREE)
									&& userTwo.getStopId().trim().equals(STOP_TWO))) {
						chargeAmount = TRIP_MID_AMOUNT;

					} else if ((userOne.getStopId().trim().equals(STOP_ONE)
							&& userTwo.getStopId().trim().equals(STOP_THREE))
							|| (userOne.getStopId().trim().equals(STOP_THREE)
									&& userTwo.getStopId().trim().equals(STOP_ONE))) {
						chargeAmount = TRIP_MAX_AMOUNT;
					}
					updateUserDetail(userOne, userTwo , userOutput);
					
				}
				/*
				 * 
				 * calculate  the cancel trip detail while comparing below condition 
				 * 1)stopId will be same 
				 * 2)both tapType will present 
				 * 3)Pan must be same 
				 * */
				
				else if (userOne.getPan().trim().equals(userTwo.getPan())
						&& (userOne.getTapType().trim().equals(TAP_ON)) && (userTwo.getTapType().trim().equals(TAP_OFF))
						&& (userOne.getStopId().trim().equals(userTwo.getStopId()))) {

					status = TRIP_STATUS_CANCEL;
					chargeAmount = TRIP_CANCEL_AMOUNT;
				}
				updateUserDetail(userOne, userTwo , userOutput);
				
			} 
			/*
			 * 
			 * calculate  the incomplete trip detail while comparing below condition 
			 * 1)one one recored should present (missing tap Off)
			 * */
			else if (!CollectionUtils.isEmpty(trips) && trips.size() == 1) {
				userOne = trips.get(0);

				status = TRIP_STATUS_INCOMPLETE;
				if (userOne.getStopId().trim().equals(STOP_ONE) || userOne.getStopId().trim().equals(STOP_THREE)) {
					chargeAmount = TRIP_MAX_AMOUNT;
				} else if (userOne.getStopId().trim().equals(STOP_TWO)) {
					chargeAmount = TRIP_MID_AMOUNT;
				}

				updateUserDetail(userOne, userOutput);
			}
		} catch (Exception e) {
			logger.error("error occured while calculating userTrips ", e.getMessage());
		}
		userOutput.setChargeAmount(chargeAmount);
		userOutput.setStatus(status);
		logger.info("Trip Status={} and chargeAmount={} ", status, chargeAmount);

		resultRecord.add(userOutput);
		return resultRecord;
	}

	private void updateUserDetail(UserInput user, UserOutput userOutput) {

		userOutput.setToStopId(user.getStopId());
		userOutput.setBusId(user.getBusId());
		userOutput.setFromStopId(user.getStopId());
		userOutput.setPan(user.getPan());
		userOutput.setCompanyId(user.getCompanyId());
	}

	private void updateUserDetail(UserInput userOneInput, UserInput userTwoInput, UserOutput userOutput) {

		userOutput.setFromStopId(userOneInput.getStopId());
		userOutput.setToStopId(userTwoInput.getStopId());
		userOutput.setPan(userTwoInput.getPan());
		userOutput.setBusId(userOneInput.getBusId());
		userOutput.setCompanyId(userTwoInput.getCompanyId());
		
	}

}
