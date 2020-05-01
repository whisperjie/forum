package com.whisper.forum.controller;

import com.whisper.forum.dao.ArticleDao;
import com.whisper.forum.entity.Article;
import com.whisper.forum.response.ResponseResult;
import com.whisper.forum.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleDao articleDao;
    @Autowired
    private ArticleServiceImpl articleService;

    @GetMapping("/add")
    public ResponseResult add(Article article) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        article.publishTime=simpleDateFormat.format(new Date());
        article.viewCount=0;//设置默认值
        ResponseResult result=null;
        try {
            articleService.addArticle(article);
            result= ResponseResult.SUCCESS();
        } catch (Exception e) {
            result= ResponseResult.FAILED();
        }
        return result;
    }
    @RequestMapping("/all")
    public ResponseResult getAll(Article article) {
        ResponseResult result=null;
        try {
            List<Article> articles=articleService.queryArticles();
            result= ResponseResult.SUCCESS();
            result.setData(articles);
        } catch (Exception e) {
            result= ResponseResult.FAILED();
        }
        return result;
    }
    @RequestMapping("/findByName")
    public ModelAndView findByName(String name) {
        //System.out.println("handle");
        ModelAndView modelAndView=new ModelAndView("article");

        modelAndView.addObject("articles",articleDao.findByTitleLike("%"+name+"%"));
        System.out.println("articles>>>>>>>>>>>>>"+articleDao.findByTitleLike("%"+name+"%"));
        // System.out.println("tag>>>>>>>>>>>>>"+tagService.findAll().toString());
        return modelAndView;
    }

    @GetMapping("/delete/id/{id}")
    public ResponseResult delete( @PathVariable int id) {
        ResponseResult result=null;
        try {
            articleService.deleteArticleById(id);
            result= ResponseResult.SUCCESS();
        } catch (Exception e) {
            result= ResponseResult.FAILED();
        }
        return result;
    }
}
