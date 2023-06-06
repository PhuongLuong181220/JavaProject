package com.example.brand.config;

import com.example.brand.config.paging.PagingResolve;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Value("${folder.image}")
    String folderImageFile;
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new PagingResolve());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry

                .addResourceHandler("/image-product/**")

                .addResourceLocations("file:/" + folderImageFile);
    }
}