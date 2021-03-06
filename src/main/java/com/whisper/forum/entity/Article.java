package com.whisper.forum.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    public String title="";//标题
    public int viewCount=0;
    public int commentCount=0;
    public int visable=0;//0 全局可见  1 好友可见 2 仅自己可见
    public String content="无";//内容 html
    public String publishTime;

    @OneToMany(cascade = CascadeType.REMOVE ,fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id",referencedColumnName = "id",updatable=false)
    public List<Comment> comments=new ArrayList<>();
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="user_id")//设置在article表中的关联字段(外键)
   // @JsonIgnore //生成json的时候忽略这个属性
    @JsonBackReference
    public User user;//所属作者

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="tag_id")//设置在article表中的关联字段(外键)
   // @JsonIgnore //生成json的时候忽略这个属性
    @JsonBackReference
    public Tag tag;//所属作者

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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    /*@Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", viewCount=" + viewCount +
                ", content='" + content + '\'' +
                ", publishTime='" + publishTime + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", viewCount=" + viewCount +
                ", content='" + content + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", comments=" + comments +
                ", user=" + user +
                ", tag=" + tag +
                '}';
    }
}
