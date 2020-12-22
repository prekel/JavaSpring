package com.github.prekel.JavaSpring.Lab08;

import com.github.prekel.JavaSpring.Lab08.entity.Furniture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJms
public class Lab08Application {
    private static final Logger LOG = LoggerFactory.getLogger(Lab08Application.class);
    private final static String apiUrl = "http://localhost:8888/furniture/";
    @Autowired
    JmsTemplate jmsTemplate;


    public static void main(String[] args) {
        var context = SpringApplication.run(Lab08Application.class, args);
        var jmsTemplate = context.getBean(JmsTemplate.class);
        jmsTemplate.setDefaultDestinationName("mailbox");
        System.out.println("Sending an email message.");

        var furnitures = getFurnitures();
        for (Furniture furniture : furnitures) {
            System.out.println(furniture);
        }
        System.out.println(getFurniture(8));
    }

    public static Furniture[] getFurnitures() {
        return new RestTemplate().getForObject(apiUrl, Furniture[].class);
    }

    public static Furniture getFurniture(int id) {
        return new RestTemplate().getForObject(apiUrl + "{id}", Furniture.class, id);
    }
}
