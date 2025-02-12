package com.unrn.edu.ar.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")  // Permite el origen del frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Incluye OPTIONS
                .allowedHeaders("*")
                .allowCredentials(true)  // Permite el uso de cookies si es necesario
                .maxAge(3600);  // Cache de preflight durante una hora
    }
}