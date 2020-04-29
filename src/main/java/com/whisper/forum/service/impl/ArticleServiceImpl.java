package com.whisper.forum.service.impl;

import com.whisper.forum.dao.ArticleDao;
import com.whisper.forum.entity.Article;
import com.whisper.forum.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> queryArticles() {
        return articleDao.findAll();
    }

    @Override
    public Article addArticle(Article article) {
        return  articleDao.save(article);
    }

    @Override
    public Article getArticleById(int id) {
        return articleDao.findById(id).get();
    }

    @Override
    public void deleteArticleById(int id) {
         articleDao.deleteById(id);
    }
}
