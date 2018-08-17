package com.info.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-07-03 上午 9:51
 **/

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    // 配置静态资源访问
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("file:C:/imooc_videos_dev/face/");
        super.addResourceHandlers(registry);
    }



}
