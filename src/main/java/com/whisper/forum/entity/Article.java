package com.whisper.forum.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    //public int authorId;//作者
    //public int tagId;
    //public int type;//0  文本，1 Markdown，2富文本
    //public int status;//0 发布,1 草稿  ,2.等待发布
    public int viewCount;
    public String content;//内容 html
    public String publishTime;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
// public Date updateTime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id",referencedColumnName = "id")
    //  @OrderBy("sequence asc")
    public List<Comment> comments=new ArrayList<>();

    public Article() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        publishTime=simpleDateFormat.format(new Date());

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", viewCount=" + viewCount +
                ", content='" + content + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", comments=" + comments +
                '}';
    }
}
