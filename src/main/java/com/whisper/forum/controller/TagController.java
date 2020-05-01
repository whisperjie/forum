package com.whisper.forum.controller;


import com.whisper.forum.dao.TagDao;
import com.whisper.forum.entity.Tag;
import com.whisper.forum.response.ResponseResult;
import com.whisper.forum.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    TagDao tagDao;
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

    @RequestMapping("/update")
    public ResponseResult update(Tag tag){
        System.out.println(tag.toString());
        try{
           // tagService.update(tag);
            tagDao.save(tag);
            return ResponseResult.SUCCESS();
        }catch (Exception e){
            return ResponseResult.FAILED();
        }
    }

    @RequestMapping("/findByName")
    public ResponseResult findByName(String content) {
       // System.out.println("handle");
       // ModelAndView modelAndView=new ModelAndView("tag");

       // modelAndView.addObject("tags",tagService.findAll());
       // System.out.println("tag>>>>>>>>>>>>>"+tagService.findAll().toString());
        ResponseResult responseResult=ResponseResult.SUCCESS();
        responseResult.setData(tagDao.findByContentLike("%"+content+"%"));
        return responseResult;
    }

    @RequestMapping("/all")
    public List<Tag> getAll(){
        return tagService.findAll();
    }
    @RequestMapping("/delete/id/{id}")
    public ResponseResult delete( @PathVariable int id){
        try{
            tagService.delete(id);
            return ResponseResult.SUCCESS();
        }catch (Exception e){
            return ResponseResult.FAILED();
        }
    }
}
