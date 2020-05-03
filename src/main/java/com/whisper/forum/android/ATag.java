package com.whisper.forum.android;

import java.util.ArrayList;
import java.util.List;

public class ATag {
    public Integer id;
    public String content="无";//内容
    public String intro="无";//简介
    public Integer sum=0;//文章数
    public boolean hot=false;//就问你hot不hot
    List<AArticle> aArticles=new ArrayList<>();

    public ATag() {
    }

    public ATag(Integer id, String content, String intro, Integer sum, boolean hot) {
        this.id = id;
        this.content = content;
        this.intro = intro;
        this.sum = sum;
        this.hot = hot;
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

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    @Override
    public String toString() {
        return "ATag{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", intro='" + intro + '\'' +
                ", sum=" + sum +
                ", hot=" + hot +
                '}';
    }
}
