package com.spring.dto;

public class DataToPredictDto {
	
	double value1;
	double value2;
	public DataToPredictDto(double value1, double value2) {
		super();
		this.value1 = value1;
		this.value2 = value2;
	}
	public DataToPredictDto() {
		super();
	}
	public double getValue1() {
		return value1;
	}
	public void setValue1(double value1) {
		this.value1 = value1;
	}
	public double getValue2() {
		return value2;
	}
	public void setValue2(double value2) {
		this.value2 = value2;
	}
	
	

}
