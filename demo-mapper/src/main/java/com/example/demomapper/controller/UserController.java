package com.example.demomapper.controller;

import com.example.demomapper.entity.User;
import com.example.demomapper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查询所有用户记录
     *
     * @return
     */
    @GetMapping("/findAll")
    public List<User> findUserPage() {
        return userService.findAll();
    }

    /**
     * 添加用户
     */
    @RequestMapping("addUser")
    public void addUser() {
        User user = new User();
        user.setAge("20");
        user.setName("张三");
        userService.addUser(user);

    }

    /**
     * 删除用户
     */
    @RequestMapping("deleteUser")
    public void deleteUser() {
        User user = new User();
        user.setId("1");
        userService.deleteUser(user);

    }

    /**
     * 更新用户
     */
    @RequestMapping("updateUser")
    public void updateUser() {
        User user = new User();
        user.setId("2");
        user.setAge("33");
        user.setName("老王");
        userService.updateUser(user);
    }

    /**
     * 通过用指定年龄段的人
     * @return
     */
    @RequestMapping("listUserByAge")
    public List<User> listUserByAge(){
        return userService.listUserByAge(20,30);
    }
}
