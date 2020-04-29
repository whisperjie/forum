package com.whisper.forum.controller;

import com.whisper.forum.entity.Article;
import com.whisper.forum.response.ResponseResult;
import com.whisper.forum.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
