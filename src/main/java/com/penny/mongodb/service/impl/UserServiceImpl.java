package com.penny.mongodb.service.impl;

import com.penny.mongodb.entity.User;
import com.penny.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    

   /* @Autowired
    private UserRepository userRepository;*/

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<User> findAll() {
        mongoTemplate.findAll(User.class);
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User findById(String id) {
        return mongoTemplate.findById(id, User.class);
    }

    @Override
    public User findUserByUserName(String user) {
        Query query =  new Query(Criteria.where("user").is(user));
        User one = mongoTemplate.findOne(query, User.class);
        return one;
    }

    @Override
    public void create(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public void delete(String id) {
        User byId = mongoTemplate.findById(id, User.class);
        mongoTemplate.remove(byId);
    }

    @Override
    public void update(User user) {
        //根据id进行更新
        Query query = new Query(Criteria.where("id").is(user.getId()));
        //创新更新对象
        Update up = new Update();
        //指定更新字段
        up.set("user", user.getUser());
        mongoTemplate.updateFirst(query, up, User.class);
    }
}
