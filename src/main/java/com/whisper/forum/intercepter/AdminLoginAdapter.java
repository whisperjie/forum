package com.whisper.forum.intercepter;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class AdminLoginAdapter implements WebMvcConfigurer {

    /*@Bean
    public LoginIntercepter getLoginIntercepter() {
    return new LoginIntercepter();
    }
*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginIntercepter loginIntercepter=new LoginIntercepter();
        InterceptorRegistration loginRegister=registry.addInterceptor(loginIntercepter);
        loginRegister.addPathPatterns("/**");
        loginRegister.excludePathPatterns("/root/login");
        loginRegister.excludePathPatterns("/user/**");
        loginRegister.excludePathPatterns("/tag/**");
        loginRegister.excludePathPatterns("/tag/android/**");
        loginRegister.excludePathPatterns("/comment/**");
        loginRegister.excludePathPatterns("/article/**");
        loginRegister.excludePathPatterns("/root/loginout");
        // 排除资源请求
        loginRegister.excludePathPatterns("/css/**");
        loginRegister.excludePathPatterns("/js/**");
        loginRegister.excludePathPatterns("/image/**");

        /* registry.addInterceptor(getLoginIntercepter()).addPathPatterns("/root/**").excludePathPatterns("/root/login");
  */

    }
}
