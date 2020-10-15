package com.github.prekel.JavaSpring.Lab04;

import com.github.prekel.JavaSpring.Lab04.component.FurnitureJdbcDao;
import com.github.prekel.JavaSpring.Lab04.component.FurnitureRepository;
import com.github.prekel.JavaSpring.Lab04.entity.Furniture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@SpringBootApplication
public class Program implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(Program.class);
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    public static void main(String[] args) {
        LOG.info("Started");
        SpringApplication.run(Program.class, args);
        LOG.info("Ended");
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("EXECUTING : command line runner");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        var rep = context.getBean("furnitureRepository", FurnitureRepository.class);

        var s = rep.findById(1);
        s.get().setHeight(123123);
        rep.save(s.get());
        var s2 = rep.findByType("Шкаф");
        rep.removeById(2);
        var s4 = rep.findAll(Sort.by(Sort.Direction.DESC, "cost"));

        for (var i : s4) {
            System.out.println(i);
        }

        var studentJdbcDao = context.getBean("furnitureJdbcDao", FurnitureJdbcDao.class);
        var vasya = new Furniture("Шкаф", "Шкафчик-3003", "Япо", new BigDecimal("23.31"), 151);
        studentJdbcDao.insert(vasya);
        var s1 = studentJdbcDao.findAll();
    }
}
