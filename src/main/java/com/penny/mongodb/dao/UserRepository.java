package com.penny.mongodb.dao;

import com.penny.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {



}
