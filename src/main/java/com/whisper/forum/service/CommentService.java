package com.whisper.forum.service;


import com.whisper.forum.entity.Comment;
import com.whisper.forum.vo.CommentVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service
public interface CommentService {

   void save();
    void find(int articleId,int replyUserId);
}
