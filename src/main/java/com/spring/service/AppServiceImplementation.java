package com.spring.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.entity.Category;
import com.spring.entity.Data;
import com.spring.entity.User;
import com.spring.repository.CategoryRepository;
import com.spring.repository.DataRepository;
import com.spring.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppServiceImplementation implements AppService {
	
	private CategoryRepository categoryRepository;
	private DataRepository dataRepository;	
	
	@Autowired
	public AppServiceImplementation(CategoryRepository categoryRepository,
			DataRepository dataRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.dataRepository = dataRepository;
	}

	@Override
	public List<Category> getAllCategories() {
		return this.categoryRepository.findAll();
	}
	
	@Override
	public Category getCategoryById(int categoryId) {
		Category cat = this.categoryRepository.getById(categoryId);
		return cat;
	}

	@Override
	public Category editCategory(Category category, int catId) {

		Category cat = this.categoryRepository.getById(catId);
		cat.setName(category.getName());
		cat.setExcerpt(cat.getExcerpt());
		cat.setValue1(category.getValue1());
		cat.setValue1(category.getValue1());
		cat.setValue1(category.getValue1());
		cat.setValue1(category.getValue1());
		cat.setValue1(category.getValue1());
		cat.setValue1(category.getValue1());
		cat.setValue1(category.getValue1());
		
		return this.categoryRepository.save(cat);
	}

	@Override
	public Category addCategory(Category cat) {

		return this.categoryRepository.save(cat);
	}

	@Override
	public Data addData(double value1, double value2, double value3, double value4, double value5, double value6, double value7, int categoryId) throws Exception {

		Category category = this.categoryRepository.getById(categoryId);
		
		if(category == null) {
			throw new Exception("Ova kategorija ne postoji");
		}
		
		Data data = new Data();
		
		data.setValue1(value1);
		data.setValue2(value2);
		data.setValue3(value3);
		data.setValue4(value4);
		data.setValue5(value5);
		data.setValue6(value6);
		data.setValue7(value7);

		data.setCategory(category);
		
		return this.dataRepository.save(data);
	}
	
}
