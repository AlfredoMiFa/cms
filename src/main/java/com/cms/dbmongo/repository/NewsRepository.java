package com.cms.dbmongo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cms.dbmongo.models.News;

public interface NewsRepository extends ReactiveMongoRepository<News, String> {

}
