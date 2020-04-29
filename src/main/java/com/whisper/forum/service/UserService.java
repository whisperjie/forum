package com.whisper.forum.service;


import com.whisper.forum.entity.User;

import java.util.List;


public interface UserService {
   User findByEmail(String email);
   List<User> findAll();
   User save(User user);
    User update(User user);
    void deleteById(Integer id);
    void deleteAll();

    User findById(Integer id);
}
