package com.whisper.forum.dao;

import com.whisper.forum.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends JpaRepository<Article,Integer> {

}
