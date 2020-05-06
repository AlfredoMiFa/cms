package com.cms.dbmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cms.dbmongo.models.Category;
import com.cms.dbmongo.repository.CategoryRepository;
import com.cms.dbmongo.vo.CategoryRequest;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public Category create(CategoryRequest request) {
		Category category = new Category();
		category.setName(request.getName());
		return this.categoryRepository.save(category);
	}
	
	public Category update(Category category) {
		return this.categoryRepository.save(category);
	}
	
	public void delete(String id) {
		final Optional<Category> category = this.categoryRepository.findById(id);
		this.categoryRepository.delete(category.get());
	}
	
	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}
	
	public Category findOne(String id) {
		Optional<Category> category = this.categoryRepository.findById(id);
		return category.get();
	}
	
}
