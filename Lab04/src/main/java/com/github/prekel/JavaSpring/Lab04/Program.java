package com.github.prekel.JavaSpring.Lab04;

import com.github.prekel.JavaSpring.Lab04.component.FurnitureJdbcDao;
import com.github.prekel.JavaSpring.Lab04.component.FurnitureRepository;
import com.github.prekel.JavaSpring.Lab04.entity.Furniture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;

@SpringBootApplication
public class Program {
    public static void main(String[] args) {
        SpringApplication.run(Program.class, args);

        var context = new AnnotationConfigApplicationContext(SpringConfig.class);

        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        var rep = context.getBean("furnitureRepository", FurnitureRepository.class);
        var s = rep.findById(1);
        var s2 = rep.findByType("Шкаф");
        var s3 = rep.findCustomAll();
        rep.removeById(2);
        var s4 = rep.findAll(Sort.by(Sort.Direction.DESC, "cost"));

        for (var i : s4)
        {
            System.out.println(i);
        }

        var studentJdbcDao = context.getBean("furnitureJdbcDao", FurnitureJdbcDao.class);
        var vasya = new Furniture("Шкаф", "Шкафчик-3003", "Япо", new BigDecimal("23.31"), 151);
        studentJdbcDao.insert(vasya);
        var s1 = studentJdbcDao.findAll();

        context.close();
    }
}
