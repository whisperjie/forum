package com.whisper.forum.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Comment {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id; //主键id

    public int userId;//用户id
    public int articleId;//帖子id
    public int replyUserId;//被回复用户id
    public int pid;//父id,几级评论;
    public String commentMsg;//回复内容
    public String createdTime;//创建时间


}
