package com.whisper.forum.test;

import com.whisper.forum.entity.User;
import com.whisper.forum.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class userTest {
    @Autowired
    static UserDao userDao;
    public static void main(String[] args) {
        User user = new User();
        user.name = "whisper";
        user.password = "password";
        user.email = "1416207703@qq.com";
        print(user.toString());
       // userRepository.save(user);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
