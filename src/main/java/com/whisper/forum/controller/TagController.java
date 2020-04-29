package com.whisper.forum.controller;


import com.whisper.forum.entity.Tag;
import com.whisper.forum.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tag")
public class TagController {
    @Autowired
    TagServiceImpl tagService;
    @RequestMapping("/add")
    public String add(Tag tag){
        try{
        tagService.addTag(tag);
        return "添加成功";
        }catch (Exception e){
            return "添加失败";
        }
    }
    @RequestMapping("/all")
    public List<Tag> getAll(){
        return tagService.findAll();
    }
}
