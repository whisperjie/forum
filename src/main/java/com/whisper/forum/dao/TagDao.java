package com.whisper.forum.dao;

import com.whisper.forum.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagDao extends JpaRepository<Tag,Integer> {
    List<Tag> findAllByOrderBySumDesc(); //令人抓狂的写法
}
