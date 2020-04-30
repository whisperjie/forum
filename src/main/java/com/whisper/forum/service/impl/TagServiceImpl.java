package com.whisper.forum.service.impl;

import com.whisper.forum.dao.TagDao;
import com.whisper.forum.entity.Tag;
import com.whisper.forum.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    public TagDao tagDao;
    @Override
    public Tag addTag(Tag tag) {
      //  Tag tag=new Tag(content,"",0,false);
        return tagDao.save(tag);
    }

    @Override
    public List<Tag> findAll() {
        return tagDao.findAll();
    }
}
