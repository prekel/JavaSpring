package com.github.prekel.JavaSpring.Lab04;

import com.github.prekel.JavaSpring.Lab04.component.FurnitureDao;
import com.github.prekel.JavaSpring.Lab04.component.FurnitureJdbcDao;
import com.github.prekel.JavaSpring.Lab04.component.FurnitureRepository;
import com.github.prekel.JavaSpring.Lab04.entity.Furniture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Lab04ApplicationTests {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	@Test
	void contextLoads() {
	}

	@Test
	public void jdbcInsertTest()
	{
		FurnitureDao dao = context.getBean("furnitureJdbcDao", FurnitureJdbcDao.class);

		var allBefore = dao.findAll();
		dao.insert(new Furniture("шкаф", "4001", "qwe", new BigDecimal("123.32"), 123));
		var allAfter = dao.findAll();

		assertEquals(1, allAfter.size() - allBefore.size());
	}

	@Test
	public void jpaInsertTest()
	{
		FurnitureDao dao = context.getBean("furnitureRepository", FurnitureRepository.class);

		var allBefore = dao.findAll();
		dao.insert(new Furniture("шкаф", "4001", "qwe", new BigDecimal("123.32"), 123));
		var allAfter = dao.findAll();

		assertEquals(1, allAfter.size() - allBefore.size());
	}
}
