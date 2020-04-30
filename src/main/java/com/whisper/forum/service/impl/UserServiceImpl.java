package com.whisper.forum.service.impl;

import com.whisper.forum.entity.User;
import com.whisper.forum.dao.UserDao;
import com.whisper.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;



    @Override
    public List<User> findByName(String name) {
        List<User> users = userDao.findByNameLike(name);
        System.out.println(users.toString());
        return users;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User update(User user) {
        return userDao.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userDao.deleteAll();
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id).get();
    }
}
