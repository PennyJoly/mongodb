package com.penny.mongodb.service;

import com.penny.mongodb.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    /**
     * 查询全部
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询一个用户
     * @param id
     * @return
     */
    User findById(String id);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User findUserByUserName(String userName);

    /**
     * 新增一个用户
     * @param user
     */
    void create(User user);

    /**
     * 根据id删除一个用户
     * @param id 用户id
     */
    void delete(String id);

    /**
     * 更改一个用户信息
     * @param user
     */
    void update(User user);
}
