package com.whisper.forum.controller;

import com.whisper.forum.entity.Article;
import com.whisper.forum.response.ResponseResult;
import com.whisper.forum.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleServiceImpl articleService;

    @PostMapping("/add")
    public ResponseResult add(Article article) {
        ResponseResult result=null;
        try {
            articleService.addArticle(article);
            result= ResponseResult.SUCCESS();
        } catch (Exception e) {
            result= ResponseResult.FAILED();
        }
        return result;
    }
    @PostMapping("/all")
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
    @GetMapping("/delete")
    public ResponseResult delete(int id) {
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
