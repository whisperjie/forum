package com.whisper.forum.entity;


import javafx.scene.input.DataFormat;
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
    public int replyUserId;//被回复用户id
    public int userId;
    public int level=0;//父id,几级评论;
    public String commentMsg="无";//回复内容
    public String createdTime;//创建时间

    /*@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="user_id")//设置在article表中的关联字段(外键)
    private User user;//所属作者


    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="article_id")//设置在article表中的关联字段(外键)
    private Article article;//所属作者*/

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

    public int getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(int replyUserId) {
        this.replyUserId = replyUserId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", replyUserId=" + replyUserId +
                ", userId=" + userId +
                ", level=" + level +
                ", commentMsg='" + commentMsg + '\'' +
                ", createdTime='" + createdTime + '\'' +
                '}';
    }
}
