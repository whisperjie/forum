package com.whisper.forum.controller;

import com.whisper.forum.cofig.ConfigProperties;
import org.hibernate.query.criteria.internal.predicate.NegatedPredicateWrapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/root")
public class RootController {
    @RequestMapping("/home")
    public ModelAndView index(){
        return new ModelAndView("home");
    }
    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }
    @PostMapping("/login")
    public ModelAndView handleLogin(String name, String password, HttpServletRequest request){
       // System.out.println(name+password);
        ModelAndView modelAndView=new ModelAndView();
        ConfigProperties configProperties=new ConfigProperties();
        System.out.println(configProperties.toString());

        if (configProperties.getName().equals(name)&&configProperties.getPassword().equals(password)){
            request.getSession().setAttribute("isLogin","true");
            modelAndView.setViewName("home");
        }else{
            modelAndView.addObject("message","登录失败");
            modelAndView.setViewName("error");
        }
        return modelAndView;

    }
}
