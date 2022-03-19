package com.spring.service;

import java.sql.Timestamp;
import java.util.List;

import com.spring.entity.Category;
import com.spring.entity.Data;
import com.spring.entity.User;

public interface AppService {

	public Data addData(double value1, double value2, double value3, double value4, double value5, double value6, double value7, int categoryId) throws Exception;
	public List<Category> getAllCategories();
	public Category getCategoryById(int kategorijaId);
	public Category addCategory(Category cat);
	public Category editCategory(Category category, int catId);
	
}
