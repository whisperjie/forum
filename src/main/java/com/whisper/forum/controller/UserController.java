package com.whisper.forum.controller;


import com.whisper.forum.dao.UserDao;
import com.whisper.forum.entity.User;
import com.whisper.forum.response.ResponseResult;
import com.whisper.forum.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserDao userDao;


    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping("/add")
    public ResponseResult add(User user) {

        ResponseResult result=null;
        try{
            User newUser=userService.save(user);
            result= ResponseResult.SUCCESS();
            result.setData(user);
        }catch (Exception e){
            result= ResponseResult.FAILED();
            e.printStackTrace();
        }
        return result;

    }

    @RequestMapping("/update")
    public ResponseResult update(User user) {
        User newuser=userService.update(user);
        ResponseResult result=null;
        if (newuser!=null){
            result= ResponseResult.SUCCESS();
            result.setData(user);
        }else{
            result= ResponseResult.NOFOUND();
        }
        return result;
    }
    @RequestMapping("/findByName")
    public ResponseResult findByEmail(String name) {
        List<User> users=userService.findByName("%"+name+"%");
        System.out.println(users.toString());
        ResponseResult result=null;
        if (users!=null){
            result= ResponseResult.SUCCESS();
            result.setData(users);
        }else{
            result= ResponseResult.NOFOUND();
        }
        return result;
    }

    @RequestMapping("/login")
    public ResponseResult login(String email, String password) {
        //  return userService.findByNameOrEmail(name,email);
        User user = userDao.findByEmail(email);
        //int message =2;
        ResponseResult result=null;
        if (user == null) {
            //message= 1;
            result=ResponseResult.NOFOUND();
        } else if (user.password.equals(password)) {
            result=ResponseResult.LOGIN_SUCCESS();
        }else{
            result=ResponseResult.FAILED();
        }
        return result;
    }

    @RequestMapping("/id/{id}")
    public ResponseResult findById(@PathVariable Integer id) {
        User user=userService.findById(id);
        ResponseResult result=null;
        if (user!=null){
            result= ResponseResult.SUCCESS();
            result.setData(user);
        }else{
            result= ResponseResult.NOFOUND();
        }
        return result;
    }

    @RequestMapping("/delete/id/{id}")
    public ResponseResult deleteById(@PathVariable Integer id) {
        try {
            userService.deleteById(id);
            return ResponseResult.SUCCESS();
        } catch (Exception e) {
            return ResponseResult.FAILED();
        }

    }

    @RequestMapping("/delete/all")
    public ResponseResult deleteAll() {
        try {
            userService.deleteAll();
            return ResponseResult.SUCCESS();
        } catch (Exception e) {
            return ResponseResult.FAILED();
        }

    }


}
