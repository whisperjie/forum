package com.whisper.forum.controller;

import com.whisper.forum.dao.CommentDao;
import com.whisper.forum.entity.Comment;
import com.whisper.forum.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentDao commentDao;
    @RequestMapping("/all")
    public ResponseResult findAll(){
        ResponseResult responseResult=ResponseResult.SUCCESS();
        responseResult.setData(commentDao.findAll());
        return responseResult ;
    }
    @RequestMapping("delete/id/{id}")
    public ResponseResult delete(@PathVariable int id){
        try{
            commentDao.deleteById(id);
            return ResponseResult.SUCCESS();        }catch (Exception e){
            return ResponseResult.FAILED();
        }
    }
    @RequestMapping("/findById")
    public ModelAndView findById(Integer id){
        System.out.println(id);
        ModelAndView modelAndView=new ModelAndView("comment");
        Comment comment=commentDao.findById(id).get();
        System.out.println(comment.toString());
        modelAndView.addObject("comments",commentDao.findAllById(Collections.singleton(id)));
        return modelAndView;
    }
}
