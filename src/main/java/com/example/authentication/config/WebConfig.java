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
        String popupPath = popupDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/images/popup/**")
                .addResourceLocations("file:/" + popupPath + "/");

        Path productsDir = Paths.get("./images/products");
        String productsPath = productsDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/images/products/**")
                .addResourceLocations("file:/" + productsPath + "/");

        Path promoDir = Paths.get("./images/promotions");
        String promoPath = promoDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/images/promotions/**")
                .addResourceLocations("file:/" + promoPath + "/");


        Path contactDir = Paths.get("./images/contacts");
        String contactPath = contactDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/images/contacts/**")
                .addResourceLocations("file:/" + contactPath + "/");





    }
}