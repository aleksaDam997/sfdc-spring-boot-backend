package com.spring.dto;

import org.hibernate.annotations.Entity;

import com.fasterxml.jackson.annotation.JsonValue;

public class TrainingDto {
	
	private double[][] inputs;
	private double[][] labels;
	private int epochs;
	private int[] nodes;
	
	public TrainingDto(double[][] inputs, double[][] labels, int epochs, int[] nodes) {
		super();
		this.inputs = inputs;
		this.labels = labels;
		this.epochs = epochs;
		this.nodes = nodes;
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
	public int getEpochs() {
		return epochs;
	}
	public void setEpochs(int epochs) {
		this.epochs = epochs;
	}
	public int[] getNodes() {
		return nodes;
	}
	public void setNodes(int[] nodes) {
		this.nodes = nodes;
	}
	
	

}
