package com.spring.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "excerpt")
	private String excerpt;
	
	@Column(name = "value1")
	private String value1;

	@Column(name = "value2")
	private String value2;
	
	@Column(name = "value3")
	private String value3;
	
	@Column(name = "value4")
	private String value4;
	
	@Column(name = "value5")
	private String value5;
	
	@Column(name = "value6")
	private String value6;
	
	@Column(name = "value7")
	private String value7;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "category")
	private Set<Data> data = new HashSet<>();

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExcerpt() {
		return this.excerpt;
	}

	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}

	public String getValue1() {
		return this.value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return this.value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public Set<Data> getData() {
		return this.data;
	}
	
	public void setAnData(Data d) {
		this.data.add(d);
	}

	public void setData(List<Data> data) {
		for(Data d : data) {
			this.data.add(d);
		}
	}
	
	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}

	public String getValue5() {
		return value5;
	}

	public void setValue5(String value5) {
		this.value5 = value5;
	}

	public String getValue6() {
		return value6;
	}

	public void setValue6(String value6) {
		this.value6 = value6;
	}

	public String getValue7() {
		return value7;
	}

	public void setValue7(String value7) {
		this.value7 = value7;
	}
	
}
