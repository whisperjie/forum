package com.whisper.forum.controller;


import com.whisper.forum.cofig.ConfigProperties;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/show_error")
    public ModelAndView handlerError() {
        // System.out.println(name+password);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","there are  some thing wrong");
        modelAndView.setViewName("error");
        return modelAndView;

    }
}
