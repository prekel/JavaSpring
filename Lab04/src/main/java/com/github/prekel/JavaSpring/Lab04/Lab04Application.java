package com.github.prekel.JavaSpring.Lab04;

import com.github.prekel.JavaSpring.Lab04.component.FurnitureJdbcDao;
import com.github.prekel.JavaSpring.Lab04.entity.Furniture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class Lab04Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab04Application.class, args);

        var context = new AnnotationConfigApplicationContext(SpringConfig.class);

        var studentJdbcDao = context.getBean("furnitureJdbcDao", FurnitureJdbcDao.class);
        var vasya = new Furniture("Шкаф", "Шкафчик-3003", "Япо", new BigDecimal("23.31"), 151);
        studentJdbcDao.insert(vasya);
        var s1 = studentJdbcDao.findAll();

        context.close();
    }
}
