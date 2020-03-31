package com.example.webstore.service;

import java.util.List;

import javax.annotation.Resource;

import com.example.webstore.dao.User.UserDao;
import com.example.webstore.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserService {
    @Resource
    UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

  /*  public void updateUser(User user) {
        userDao.updateUser(user);
    }
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }*/
}
