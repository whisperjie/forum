package com.whisper.forum.entity;


import javafx.scene.input.DataFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Entity
//@Data
public class Comment {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id; //主键id

    //public int userId;//用户id
   // public int articleId;//帖子id
    public int replyUserId;//被回复用户id
    public int level=0;//父id,几级评论;
    public String commentMsg;//回复内容
    public String createdTime;//创建时间

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", replyUserId=" + replyUserId +
                ", level=" + level +
                ", commentMsg='" + commentMsg + '\'' +
                ", createdTime='" + createdTime + '\'' +
                '}';
    }

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


}
