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
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);
        var studentJdbcDao = context.getBean("furnitureJdbcDao", FurnitureJdbcDao.class);
        var vasya = new Furniture(5, "Шкаф", "Шкафчик-3000", "Япо", new BigDecimal("23.45"), 150);
        studentJdbcDao.insert(vasya);
        context.close();
    }
}
