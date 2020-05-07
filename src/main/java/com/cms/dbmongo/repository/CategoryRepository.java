package com.cms.dbmongo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cms.dbmongo.models.Category;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {

}
