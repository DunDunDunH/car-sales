package com.dun.service;

import com.dun.entity.User;

import java.util.List;

public interface UserService {

    List<User> getList();

    User getByName(String name);

    void deleteById(String id);

    boolean isExistName(String name,String id);

    boolean isExistPhone(String phone, String id);

    void insert(User user);
}
