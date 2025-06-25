package com.hospital.system.config;


import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {


    public void addCorsMapping(CorsRegistry registry) {
        registry.addMapping("/")
                .allowedOriginPatterns("http://127.0.0.1:5500/p1.html")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);

    }


}
