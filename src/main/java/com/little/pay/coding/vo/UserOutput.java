/**
 * 
 */
package com.little.pay.coding.vo;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author patel
 *
 */

public class UserOutput {

	private String started;
	private String finished;
	private String durationSecs;
	private String fromStopId;
	private String toStopId;
	private String companyId;
	private String busId;
	private String pan;
	private String chargeAmount;
	private String status;

	public String getStarted() {
		return started;
	}

	public void setStarted(String started) {
		this.started = started;
	}

	public String getFinished() {
		return finished;
	}

	public void setFinished(String finished) {
		this.finished = finished;
	}

	public String getDurationSecs() {
		return durationSecs;
	}

	public void setDurationSecs(String durationSecs) {
		this.durationSecs = durationSecs;
	}

	public String getFromStopId() {
		return fromStopId;
	}

	public void setFromStopId(String fromStopId) {
		this.fromStopId = fromStopId;
	}

	public String getToStopId() {
		return toStopId;
	}


	public void setToStopId(String toStopId) {
		this.toStopId = toStopId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public String getPan() {
		return pan;
	}


	public void setPan(String pan) {
		this.pan = pan;
	}


	public String getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(String chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

}
