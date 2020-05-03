package com.whisper.forum.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Focus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int userFriendId;//被关注者id
    public int userId; //用户id

}
