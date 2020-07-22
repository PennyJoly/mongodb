package com.penny.mongodb;

import com.penny.mongodb.dao.UserRepository;
import com.penny.mongodb.entity.User;
import com.penny.mongodb.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MongodbApplicationTests {


    @Autowired
    private UserService userService;


    @Test
    public void test(){
        System.out.println(userService.findUserByUserName("神奇"));
    }

    @Test
    public void test2(){
        //User user = userService.findById("555");
        User user =  new User();
        user.setId("555");
        user.setUser("测试用户2");
        userService.update(user);
    }

}
