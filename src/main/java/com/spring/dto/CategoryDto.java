package com.spring.dto;

import java.util.HashSet;
import java.util.Set;

import com.spring.entity.Data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private int categoryId;

	private String name;

	private String excerpt;

	private String value1;

	private String value2;

	private String value3;

	private String value4;

	private String value5;

	private String value6;

	private String value7;

	private Set<Data> data = new HashSet<>();
}
