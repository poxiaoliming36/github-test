package com.example.demomapper.service.impl;


import com.example.demomapper.entity.User;
import com.example.demomapper.mapper.UserMapper;
import com.example.demomapper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 查找所有用户
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    /**
     * 添加用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    /**
     * 删除用户
     * @param user
     */
    @Override
    public void deleteUser(User user) {
        userMapper.deleteByPrimaryKey(user);
    }

    /**
     * 更新用户
     * @param user
     */
    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);

    }

    /**
     * 查询指定年龄段的用户
     * @param minAge
     * @param maxAge
     * @return
     */
    @Override
    public List<User> listUserByAge(int minAge, int maxAge) {
        Example example = new Example(User.class);
        example.createCriteria().andGreaterThan("age",minAge).andLessThan("age",maxAge);
        return userMapper.selectByExample(example);

    }


}
