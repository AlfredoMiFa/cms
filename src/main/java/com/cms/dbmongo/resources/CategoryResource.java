package com.cms.dbmongo.resources;

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

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/category")
public class CategoryResource {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryResource.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Mono<Category>> findOne(@PathVariable("id") String id) {
		return ResponseEntity.ok(this.categoryService.findOne(id));
	}
	
	@GetMapping
	public ResponseEntity<Flux<Category>> findAll() {
		return ResponseEntity.ok(this.categoryService.findAll());
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<Mono<Category>> newCategory(CategoryRequest category) {
		log.info("Category {} added",category);
		return new ResponseEntity<>(this.categoryService.create(category), HttpStatus.CREATED);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeCategory(@PathVariable("id") String id) {
		this.categoryService.delete(id);
		log.info("Category removed {}",id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Mono<Category>> updateCategory(@PathVariable("id") String id, CategoryRequest category) {
		return new ResponseEntity<>(this.categoryService.update(id, category), HttpStatus.OK);
	}
	
}
