package com.spring.dto;

import org.hibernate.annotations.Entity;

import com.fasterxml.jackson.annotation.JsonValue;

public class TrainingDto {
	
	private double[][] inputs;
	private double[][] labels;
	
	public TrainingDto(double[][] inputs, double[][] labels) {
		super();
		this.inputs = inputs;
		this.labels = labels;
	}
	public TrainingDto() {
		super();
	}
	
	public double[][] getInputs() {
		return inputs;
	}
	public void setInputs(double[][] inputs) {
		this.inputs = inputs;
	}
	public double[][] getLabels() {
		return labels;
	}
	public void setLabels(double[][] labels) {
		this.labels = labels;
	}
	
	

}
