package com.whisper.forum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int authorId;//作者
    public int tagId;
    //public int type;//0  文本，1 Markdown，2富文本
    //public int status;//0 发布,1 草稿  ,2.等待发布
    public int viewCount;
    public String content;//内容 html
    public String publishTime;
    // public Date updateTime;

}
