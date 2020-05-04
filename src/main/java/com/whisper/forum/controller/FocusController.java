package com.whisper.forum.controller;


import com.whisper.forum.dao.FocusDao;
import com.whisper.forum.dao.UserDao;
import com.whisper.forum.entity.Focus;
import com.whisper.forum.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/focus")
public class FocusController {
    @Autowired
    UserDao userDao;
    @Autowired
    FocusDao focusDao;

    @GetMapping("/add")
    public ResponseResult add(int userId, int userFriendId) {
        Focus focus = new Focus();
        focus.user = userDao.getOne(userId);
        focus.userFriendId = userFriendId;
        try {
            focusDao.save(focus);
            return ResponseResult.SUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.FAILED();

        }
    }

    @GetMapping("/delete/{id}")
    public ResponseResult delete(@PathVariable int id) {
        try {
            focusDao.deleteById(id);
            return ResponseResult.SUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.FAILED();
        }
    }
}
