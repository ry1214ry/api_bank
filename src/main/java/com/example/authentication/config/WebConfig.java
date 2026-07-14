package com.example.authentication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {


        Path popupDir = Paths.get("./popup");
        registry.addResourceHandler("/images/popup/**")
                .addResourceLocations(popupDir.toAbsolutePath().toUri().toString());

        Path productsDir = Paths.get("./images/products");
        registry.addResourceHandler("/images/products/**")
                .addResourceLocations(productsDir.toAbsolutePath().toUri().toString());

        Path promoDir = Paths.get("./images/promotions");
        registry.addResourceHandler("/images/promotions/**")
                .addResourceLocations(promoDir.toAbsolutePath().toUri().toString());


        Path contactDir = Paths.get("./images/contacts");
        registry.addResourceHandler("/images/contacts/**")
                .addResourceLocations(contactDir.toAbsolutePath().toUri().toString());


        Path newsDir = Paths.get("./images/news");
        registry.addResourceHandler("/images/news/**")
                .addResourceLocations(newsDir.toAbsolutePath().toUri().toString());
    }
}