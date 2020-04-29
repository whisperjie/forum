package com.whisper.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/root")
public class RootController {
    @RequestMapping("/index")
    public String index(){
        return "home";
    }
}
