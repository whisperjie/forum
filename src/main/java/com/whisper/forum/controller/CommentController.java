package com.whisper.forum.controller;

import com.whisper.forum.dao.ArticleDao;
import com.whisper.forum.dao.CommentDao;
import com.whisper.forum.dao.UserDao;
import com.whisper.forum.entity.Comment;
import com.whisper.forum.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    UserDao userDao;
    @Autowired
    ArticleDao articleDao;
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
            return ResponseResult.SUCCESS();
        }catch (Exception e){
            return ResponseResult.FAILED();
        }
    }
    @RequestMapping("androidAdd")
    public ResponseResult addForAndroid(String commentMsg,int articleId,int userId){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

        Comment comment=new Comment();
        comment.article=articleDao.getOne(articleId);

        comment.createdTime=simpleDateFormat.format(new Date());
        comment.commentMsg=commentMsg;
        comment.level=0;//直接默认全部都一级评论

        comment.replyCommentId=0;
        comment.user=userDao.findById(userId).get();
        //comment.article=articleDao.findById(articleId).get();
        comment.article.viewCount+=1; //这个为什么不行
        ResponseResult result=null;
        try {
            commentDao.save(comment);
            result= ResponseResult.SUCCESS();
        } catch (Exception e) {
            result= ResponseResult.FAILED();
        }
        return result;
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
