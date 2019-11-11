package com.cn.dao;


import com.cn.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  UserMapper {

    public User getUserById(int id);
    public List<User> getAllUsers();
    public void saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
}
