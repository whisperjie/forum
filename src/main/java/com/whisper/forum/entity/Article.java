package com.whisper.forum.entity;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Entity
//@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int UserId=0;
    public String title="";//标题
    public int viewCount=0;
    public String content="无";//内容 html
    public String publishTime;

    /*@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="author_id")//设置在article表中的关联字段(外键)
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id",referencedColumnName = "id")
    //  @OrderBy("sequence asc")
    public List<Comment> comments=new ArrayList<>();


    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="user_id")//设置在article表中的关联字段(外键)
    private User user;//所属作者

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="tag_id")//设置在article表中的关联字段(外键)
    private Tag tag;//所属作者*/

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

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
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
                ", UserId=" + UserId +
                ", title='" + title + '\'' +
                ", viewCount=" + viewCount +
                ", content='" + content + '\'' +
                ", publishTime='" + publishTime + '\'' +
                '}';
    }
}
