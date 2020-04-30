package com.whisper.forum.dao;

import com.whisper.forum.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommentDao extends  JpaRepository<Comment,Integer> {

}
