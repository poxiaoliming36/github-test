package com.example.demomapper.service;

import com.example.demomapper.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    List<User> listUserByAge(int minAge, int maxAge);
}
