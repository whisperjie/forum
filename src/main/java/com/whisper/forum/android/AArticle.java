package com.whisper.forum.android;

public class AArticle {
    public int id;
    public String title="";//标题
    public int viewCount=0; //浏览量
    public String content="无";//内容 html
    public String userName; //作者id
    public int userId; //作者name
    public int tagId; //标签id
    public String tagName; //标签name
    public String publishTime;

    public AArticle() {
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

    @Override
    public String toString() {
        return "AArticle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", viewCount=" + viewCount +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", userId=" + userId +
                ", tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}
