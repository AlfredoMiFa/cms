package com.cms.dbmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cms.dbmongo.models.News;

public interface NewsRepository extends MongoRepository<News, String> {

}
