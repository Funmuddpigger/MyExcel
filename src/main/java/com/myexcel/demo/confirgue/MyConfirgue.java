package com.myexcel.demo.confirgue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfirgue implements WebMvcConfigurer{
        @Bean
        public WebMvcConfigurer webMvcConfigurer(){
            WebMvcConfigurer configurer = new WebMvcConfigurer() {
                @Override
                public void addViewControllers(ViewControllerRegistry registry) {
                    registry.addViewController("/").setViewName("/html/excel");
                }
            };
            return configurer;
        }
}
