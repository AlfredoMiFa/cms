package com.cms.dbmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cms.dbmongo.models.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
