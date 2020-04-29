package com.whisper.forum.service;

import com.whisper.forum.entity.Tag;

import java.util.List;

public interface TagService {
    Tag addTag(Tag tag);
    List<Tag> findAll();

}
