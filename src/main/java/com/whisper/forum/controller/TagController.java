package com.whisper.forum.controller;


import com.whisper.forum.entity.Tag;
import com.whisper.forum.response.ResponseResult;
import com.whisper.forum.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    TagServiceImpl tagService;
    @RequestMapping("/add")
    public ResponseResult add(Tag tag){
        try{
        tagService.addTag(tag);
        return ResponseResult.SUCCESS();
        }catch (Exception e){
            return ResponseResult.FAILED();
        }
    }
    @RequestMapping("/all")
    public List<Tag> getAll(){
        return tagService.findAll();
    }
    @RequestMapping("/delete")
    public ResponseResult delete(int id){
        try{
            tagService.delete(id);
            return ResponseResult.SUCCESS();
        }catch (Exception e){
            return ResponseResult.FAILED();
        }
    }
}
