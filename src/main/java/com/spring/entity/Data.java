package com.spring.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "data")
public class Data {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "data_id")
	private int dataId;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId", referencedColumnName = "category_id")
	private Category category;
	
	@Column(name = "created_at")
	@CreationTimestamp
	private Timestamp createdAt;
	
	@Column(name = "value1")
	private double value1;
	
	@Column(name = "value2")
	private double value2;
	
	@Column(name = "value3")
	private double value3;
	
	@Column(name = "value4")
	private double value4;
	
	@Column(name = "value5")
	private double value5;
	
	@Column(name = "value6")
	private double value6;
	
	@Column(name = "value7")
	private double value7;
	
	public double getValue3() {
		return value3;
	}

	public void setValue3(double value3) {
		this.value3 = value3;
	}

	public double getValue4() {
		return value4;
	}

	public void setValue4(double value4) {
		this.value4 = value4;
	}

	public double getValue5() {
		return value5;
	}

	public void setValue5(double value5) {
		this.value5 = value5;
	}

	public double getValue6() {
		return value6;
	}

	public void setValue6(double value6) {
		this.value6 = value6;
	}

	public double getValue7() {
		return value7;
	}

	public void setValue7(double value7) {
		this.value7 = value7;
	}

	public int getDataId() {
		return dataId;
	}

	public void setDataId(int dataId) {
		this.dataId = dataId;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
