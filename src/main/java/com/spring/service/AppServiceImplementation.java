package com.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.CategoryDto;
import com.spring.entity.Category;
import com.spring.entity.Data;
import com.spring.repository.CategoryRepository;
import com.spring.repository.DataRepository;

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
	public CategoryDto getCategoryById(int categoryId) {
		Category cat = this.categoryRepository.findById(categoryId).get();
		
		CategoryDto catDto = new CategoryDto();
		
		Set<Data> data = this.dataRepository.findByCategoryCategoryId(cat.getCategoryId());
		
		catDto.setCategoryId(cat.getCategoryId());
		catDto.setName(cat.getName());
		catDto.setExcerpt(cat.getExcerpt());
		catDto.setValue1(cat.getValue1());
		catDto.setValue2(cat.getValue2());
		catDto.setValue3(cat.getValue3());
		catDto.setValue4(cat.getValue4());
		catDto.setValue5(cat.getValue5());
		catDto.setValue6(cat.getValue6());
		catDto.setValue7(cat.getValue7());
		
		catDto.setData(data);
		
		return catDto;
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
