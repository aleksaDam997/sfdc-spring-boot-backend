package com.spring.dto;

public class Prediction {

	private String value;
	
	public Prediction(double[] b) {

		if(b[0] > b[1]) {
			value = "Predikcija je 0";
		}else {
			value = "Predikcija je 1";
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
