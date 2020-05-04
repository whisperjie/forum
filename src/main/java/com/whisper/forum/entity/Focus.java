package com.whisper.forum.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Focus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public int userFriendId;//被关注者id

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="user_id")//设置在article表中的关联字段(外键)
    @JsonBackReference
    public User user; //用户id

}
