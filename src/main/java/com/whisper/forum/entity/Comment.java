package com.whisper.forum.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
//@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id; //主键id
    public int replyCommentId=0;
    public int level=0;//父id,几级评论;
    public String commentMsg="无";//回复内容
    public String createdTime;//创建时间

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="user_id")//设置在article表中的关联字段(外键)
    //@JsonIgnore //生成json的时候忽略这个属性
    @JsonBackReference
    public User user;//所属作者
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH,},optional=false,fetch = FetchType.EAGER)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="article_id")//设置在article表中的关联字段(外键)
    //@JsonIgnore //生成json的时候忽略这个属性
    @JsonBackReference
    public Article article;//所属作者



    public Comment() {
        //Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        createdTime=simpleDateFormat.format(new Date());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(int replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCommentMsg() {
        return commentMsg;
    }

    public void setCommentMsg(String commentMsg) {
        this.commentMsg = commentMsg;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", replyCommentId=" + replyCommentId +
                ", level=" + level +
                ", commentMsg='" + commentMsg + '\'' +
                ", createdTime='" + createdTime + '\'' +
                '}';
    }
}
