package com.whisper.forum.controller;

import com.whisper.forum.entity.Article;
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
    public String add(Article article){
        articleService.addArticle(article);
        return "editor/editormd";
    }
}
