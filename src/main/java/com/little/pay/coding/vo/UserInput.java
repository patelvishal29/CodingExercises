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

public class UserInput {
	
	@CsvBindByName(column = "ID")
	private String id;
	 @CsvBindByName(column = "DateTimeUTC")
	private String dateTime;
	 @CsvBindByName(column = "TapType")
	private String tapType;
	 @CsvBindByName(column = "StopId")
	private String stopId;
	 @CsvBindByName(column = "CompanyId")
	private String companyId;
	 @CsvBindByName(column = "BusId") 
	private String busId;
	 @CsvBindByName(column = "PAN")
	private String pan;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getTapType() {
		return tapType;
	}
	public void setTapType(String tapType) {
		this.tapType = tapType;
	}
	public String getStopId() {
		return stopId;
	}
	public void setStopId(String stopId) {
		this.stopId = stopId;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	/*
	 * @CsvBindByName(column = "ID") private String id;
	 * 
	 * @CsvBindByName(column = "DateTimeUTC") private String dateTime;
	 * 
	 * @CsvBindByName(column = "TapType") private String tapType;
	 * 
	 * @CsvBindByName(column = "StopId") private String stopId;
	 * 
	 * @CsvBindByName(column = "CompanyId") private String companyId;
	 * 
	 * @CsvBindByName(column = "BusId") private String busId;
	 * 
	 * @CsvBindByName(column = "PAN") private String pan;
	 */

}
