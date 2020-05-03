package com.whisper.forum.android;

public class AComment {
    public int id; //主键id
    public int replyCommentId=0;//被回复评论id 0表示文章评论
    public int level=0;//  0表示文章评论
    public String commentMsg="无";//回复内容
    public String createdTime;//创建时间
    public int userId=0;//评论者id
    public String userName="无";//评论人用户名
    public int articleId; //文章内容
    public String articleTitle; //文章名称

    public AComment() {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Override
    public String toString() {
        return "AComment{" +
                "id=" + id +
                ", replyCommentId=" + replyCommentId +
                ", level=" + level +
                ", commentMsg='" + commentMsg + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                '}';
    }
}
