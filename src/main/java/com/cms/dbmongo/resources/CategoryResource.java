package com.cms.dbmongo.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dbmongo.models.Category;
import com.cms.dbmongo.service.CategoryService;
import com.cms.dbmongo.vo.CategoryRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/category")
@Api(tags = "category", description = "Category API")
public class CategoryResource {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryResource.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value="/{id}")
	@ApiOperation(value = "Find category", notes = "Find the category by ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Category found"),
			@ApiResponse(code = 404, message = "Category not found")})
	public ResponseEntity<Category> findOne(@PathVariable("id") String id) {
		Category category = categoryService.findOne(id);
		return ResponseEntity.ok(category);
	}
	
	@GetMapping
	@ApiOperation(value = "List categories", notes = "List all categories")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Categories found"),
			@ApiResponse(code = 404, message = "Category not found")})
	public ResponseEntity<List<Category>> findAll() {
		return ResponseEntity.ok(categoryService.findAll());
	}
	
	@PostMapping(value="/add")
	@ApiOperation(value = "Create category", notes = "It permite to create a new category")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Category created successfully"),
			@ApiResponse(code = 404, message = "Invalid request")})
	public ResponseEntity<Category> newCategory(CategoryRequest category) {
		log.info("Category {} added",category);
		Category catego = categoryService.create(category);
		return new ResponseEntity<>(catego, HttpStatus.CREATED);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Remove category", notes = "It permite to remove a category")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Category removed successfully"),
			@ApiResponse(code = 404, message = "Category not found")})
	public void removeCategory(@PathVariable("id") String id) {
		categoryService.delete(id);
		log.info("Category removed {}",id);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Update category", notes = "It permite to update a category")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Category updated successfully"),
			@ApiResponse(code = 404, message = "Category not found"),
			@ApiResponse(code = 400, message = "Invalid request")})
	public ResponseEntity<Category> updateCategory(@PathVariable("id") String id, CategoryRequest category) {
		Category cat = categoryService.findOne(id);
		cat.setName(category.getName());
		Category cate = categoryService.update(cat);
		return new ResponseEntity<>(cate, HttpStatus.OK);
	}
	
}
