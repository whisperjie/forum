package com.whisper.forum.dao;

import com.whisper.forum.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao extends JpaSpecificationExecutor<Article>, JpaRepository<Article, Integer> {
    List<Article> findByTitleLike(String title);
    //List<Article> findAllByUser
}
