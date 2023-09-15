package com.prakash.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);

        registry
                .addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","PUT","PATCh","DELETE","OPTIONS")
                .allowedHeaders("*")
                .maxAge(3600);
    }
}
