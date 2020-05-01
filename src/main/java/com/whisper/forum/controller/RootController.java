package com.whisper.forum.controller;

import com.whisper.forum.cofig.ConfigProperties;
import com.whisper.forum.dao.CommentDao;
import com.whisper.forum.dao.TagDao;
import com.whisper.forum.dao.UserDao;
import com.whisper.forum.service.TagService;
import com.whisper.forum.service.impl.ArticleServiceImpl;
import com.whisper.forum.service.impl.TagServiceImpl;
import com.whisper.forum.service.impl.UserServiceImpl;
import org.hibernate.query.criteria.internal.predicate.NegatedPredicateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/root")
public class RootController {
    @Autowired
    UserDao userDao;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    TagDao tagDao;
    @Autowired
    TagServiceImpl tagService;
    @Autowired
    ArticleServiceImpl articleService;
    @Autowired
    CommentDao commentDao;

    @RequestMapping("/home")
    public ModelAndView home(HttpServletRequest request){
        String str= (String) request.getSession().getAttribute("isLogin");
        System.out.println("session form home>>>>>"+str);
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("isLogined",str);
        return modelAndView;

    }

    @RequestMapping("/user/handle")
    public ModelAndView userHandle() {
        System.out.println("handle");
        ModelAndView modelAndView=new ModelAndView("user");

        modelAndView.addObject("users",userDao.findAll());
       // System.out.println("tag>>>>>>>>>>>>>"+userService.findAll().toString());
        return modelAndView;
    }
    //@RequestMapping("/handle#")
    @RequestMapping("/tag/handle")
    public ModelAndView handle() {
        //System.out.println("handle");
        ModelAndView modelAndView=new ModelAndView("tag");

        modelAndView.addObject("tags",tagService.findAll());
        // System.out.println("tag>>>>>>>>>>>>>"+tagService.findAll().toString());
        return modelAndView;
    }
    @RequestMapping("/comment/handle")
    public ModelAndView commentHandle() {
        System.out.println("handle");
        ModelAndView modelAndView=new ModelAndView("comment");

        modelAndView.addObject("comments",commentDao.findAll());
        //System.out.println("comment>>>>>>>>>>>>>"+commentDao.findAll().toString());
        return modelAndView;
    }
    //@RequestMapping("/handle#")
    @RequestMapping("/article/handle")
    public ModelAndView articleHandle() {
        //System.out.println("handle");
        ModelAndView modelAndView=new ModelAndView("article");

        modelAndView.addObject("articles",articleService.queryArticles());
        System.out.println("articles>>>>>>>>>>>>>"+articleService.queryArticles().toString());
        // System.out.println("tag>>>>>>>>>>>>>"+tagService.findAll().toString());
        return modelAndView;
    }
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request){
        String str= (String) request.getSession().getAttribute("isLogin");
        System.out.println("session form index>>>>>"+str);
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("isLogined",str);
        return modelAndView;

    }
    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping("/test")
    public ModelAndView test(){
        System.out.println("我被拦截");
        return new ModelAndView("test");
    }
    @PostMapping("/login")
    public String handleLogin(String name, String password, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       // System.out.println(name+password);
        ModelAndView modelAndView=new ModelAndView();
        ConfigProperties configProperties=new ConfigProperties();
        System.out.println(configProperties.toString());

        if (configProperties.getName().equals(name)&&configProperties.getPassword().equals(password)){
            System.out.println("走的home");
            request.getSession().setAttribute("isLogin","true");
            String str= (String) request.getSession().getAttribute("isLogin");
            System.out.println("session>>>>>"+str);
           // response.sendRedirect("/root/home");
            //request.getRequestDispatcher("home.html").forward(request,response);
            //modelAndView.setViewName("home");
            //response.sendRedirect(request.getContextPath()+"");
            return "home";


        }else{
            System.out.println("走的login");
            modelAndView.addObject("message","登录失败");
           // modelAndView.setViewName("error");
            return "login";

        }


    }
    @RequestMapping("/loginout")
    public ModelAndView loginOut(HttpServletRequest request){
        request.getSession().invalidate();
        return new ModelAndView("login");
    }


}
