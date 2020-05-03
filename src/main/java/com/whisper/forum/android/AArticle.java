package com.whisper.forum.android;

import com.whisper.forum.entity.Comment;

import java.util.ArrayList;
import java.util.List;

public class AArticle {
    public int id;
    public String title="";//标题
    public int viewCount=0; //浏览量
    public int commentCount;
    public int visable;//可见性
    public String content="无";//内容 html
    public String userName; //作者id
    public int userId; //作者name
    public int tagId; //标签id
    public String tagName; //标签name
    public String publishTime;
    public List<AComment> comments=new ArrayList<>();

    public AArticle() {
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getVisable() {
        return visable;
    }

    public void setVisable(int visable) {
        this.visable = visable;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public List<AComment> getComments() {
        return comments;
    }

    public void setComments(List<AComment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "AArticle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", viewCount=" + viewCount +
                ", commentCount=" + commentCount +
                ", visable=" + visable +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", userId=" + userId +
                ", tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", comments=" + comments +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
