package com.whisper.forum.service;

import com.whisper.forum.entity.Article;

import java.util.List;

public interface ArticleService {
    //查询所有的文章
    List<Article> queryArticles();
    //新增一个文章
    Article addArticle(Article article);
    //根据文章id查询文章
    Article getArticleById(int id);
    //根据文章id删除文章
    void deleteArticleById(int id);

}
