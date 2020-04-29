package com.whisper.forum.controller;


import com.whisper.forum.entity.User;
import com.whisper.forum.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/all")
    public List<User> findAll(){
        return userService.findAll();
    }
    @RequestMapping("/add")
    public String add(User user){
        try{
            userService.save(user);
            return "插入成功";
        }catch (Exception e){
           // e.printStackTrace();
            return "插入失败";
        }

    }
    @RequestMapping("/update")
    public String update(User user){
        try{
            userService.update(user);
            return "更新成功";
        }catch (Exception e){
            e.printStackTrace();
            return "更新失败";
        }
    }
    @RequestMapping("/findByNameOrEmail")
    public User findByNameOrEmail(String name,String email){
        return userService.findByNameOrEmail(name,email);
    }
    @RequestMapping("/id/{id}")
    public User findById( @PathVariable Integer id){
        return userService.findById(id);
    }
    @RequestMapping("/delete/id/{id}")
    public String deleteById( @PathVariable Integer id){
        try{ userService.deleteById(id);
            return "删除成功";
    }catch (Exception e){
            return  "删除失败";
        }

    }
    @RequestMapping("/delete/all")
    public String deleteAll( ){
        try{ userService.deleteAll();
            return "删除成功";
        }catch (Exception e){
            return  "删除失败";
        }

    }


}
