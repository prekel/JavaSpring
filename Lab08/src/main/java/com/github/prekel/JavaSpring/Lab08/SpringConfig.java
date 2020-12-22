package com.github.prekel.JavaSpring.Lab08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.util.Properties;

@Configuration
public class SpringConfig {
//    public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
//        var resolver = new ContentNegotiatingViewResolver();
//        resolver.setContentNegotiationManager(contentNegotiationManager());
//        return resolver;
//    }
//
//    @Bean
//    public ContentNegotiationManager contentNegotiationManager() {
//        var managerFactory = new ContentNegotiationManagerFactoryBean();
//        managerFactory.setFavorParameter(true);
//        managerFactory.setIgnoreAcceptHeader(true);
//        //managerFactory.setUseJaf(false);
//        managerFactory.setUseRegisteredExtensionsOnly(true);
//        managerFactory.setDefaultContentType(MediaType.TEXT_HTML);
//        var mediaTypes = new Properties();
//        mediaTypes.put("html", "text/html");
//        mediaTypes.put("json", "application/json");
//        managerFactory.setMediaTypes(mediaTypes);
//        return managerFactory.build();
//    }
}
