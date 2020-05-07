package com.cms.dbmongo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cms.dbmongo.models.User;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

}
