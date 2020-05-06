package com.cms.dbmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cms.dbmongo.models.User;

public interface UserRepository extends MongoRepository<User, String> {

}
