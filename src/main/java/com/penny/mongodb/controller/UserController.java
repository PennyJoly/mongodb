package com.penny.mongodb.controller;

import com.penny.mongodb.entity.User;
import com.penny.mongodb.service.UserService;
import com.penny.mongodb.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/findAll")
    @ResponseBody
    public Result findAll(){
        return Result.ok(userService.findAll());
    }

    /**
     * 根据Id查询一个
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Result findOne(@PathVariable String id){
        return Result.ok(userService.findById(id));
    }

    /**
     * 保存
     * @param user
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestBody User user){
        //mongo可不设置Id,其默认主键自增，可自动生成id
        userService.create(user);
        return Result.ok();
    }

    /**
     * 根据id删除一个
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable String id){
        if(!StringUtils.isEmpty(id)){
            userService.delete(id);
            return Result.ok("删除成功！");
        }
        return Result.error(500,"删除失败！");
    }

    /**
     * 条件查询，根据名称查询
     * @param user
     * @return
     */
    @GetMapping("/findByName")
    @ResponseBody
    public Result findByName(@RequestParam(value = "user",required = false) String user){
        User userByName = userService.findUserByUserName(user);
        return Result.ok(userByName);
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody User user){
        userService.update(user);
        return Result.ok("更新成功！");
    }

}
