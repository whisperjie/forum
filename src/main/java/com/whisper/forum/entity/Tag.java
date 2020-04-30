package com.whisper.forum.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String content="无";//内容
    public String intro="无";//简介
    public Integer sum=0;//文章数
    public boolean hot=false;//就问你hot不hot

/*

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id",referencedColumnName = "id")
    //  @OrderBy("sequence asc")
    public List<Article> articles=new ArrayList<>();

    public Tag(String content, String intro, Integer sum, boolean hot) {
        this.content = content;
        this.intro = intro;
        this.sum = sum;
        this.hot = hot;
    }
*/

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", intro='" + intro + '\'' +
                ", sum=" + sum +
                ", hot=" + hot +
                '}';
    }

    public Tag() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }


}
