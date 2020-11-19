package com.github.prekel.JavaSpring.Lab05;

import com.github.prekel.JavaSpring.Lab05.component.FurnitureDao;
import com.github.prekel.JavaSpring.Lab05.component.FurnitureJdbcDao;
import com.github.prekel.JavaSpring.Lab05.component.FurnitureRepository;
import com.github.prekel.JavaSpring.Lab05.entity.Furniture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class Program implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(Program.class);
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final SpringConfig config = context.getBean("springConfig", SpringConfig.class);
    private FurnitureDao furnitureDao;

    public static void main(String[] args) {
        LOG.info("Started");
        SpringApplication.run(Program.class, args);
        LOG.info("Ended");
    }

    @Override
    public void run(String... args) throws Exception {
        furnitureDao = new ReadWithCheckBuilder<Integer>()
                .hasMessage("1 - JdbcTemplate, 2 - JpaRepository: ")
                .hasChecker(number -> 1 <= number && number <= 2)
                .hasParser(Integer::parseInt)
                .readCycle() == 1
                ? context.getBean("furnitureJdbcDao", FurnitureJdbcDao.class)
                : context.getBean("furnitureRepository", FurnitureRepository.class);

        System.out.println("1 - Ввести поля сущности и добавить её в таблицу БД");
        System.out.println("2 - Вывести все записи из таблицы БД");
        System.out.println("3 - Редактировать запись таблицы БД по Id");
        System.out.println("4 - Удалить запись по Id");
        System.out.println("5 - Осуществить поиск по типу");
        System.out.println("6 - Вывести запись из таблицы БД по Id");
        System.out.println("0 - Выход из программы");

        while (true) {
            switch (new ReadWithCheckBuilder<Integer>()
                    .hasMessage("Введите номер команды: ")
                    .hasParser(Integer::parseInt)
                    .hasChecker(number -> 0 <= number && number <= 6)
                    .readCycle()) {
                case 1 -> furnitureDao
                        .insert(furnitureFromInput());
                case 2 -> furnitureDao
                        .findAll()
                        .forEach(System.out::println);
                case 3 -> furnitureDao
                        .findById(new ReadWithCheckBuilder<Integer>()
                                .hasMessage("Введите Id для редактирования: ")
                                .hasChecker(id -> id > 0)
                                .hasParser(Integer::parseInt)
                                .readCycle())
                        .ifPresentOrElse(
                                furniture -> furnitureDao.updateById(furniture.getId(), furnitureFromInput()),
                                () -> System.out.println("Нет такой записи")
                        );
                case 4 -> furnitureDao
                        .findById(new ReadWithCheckBuilder<Integer>()
                                .hasMessage("Введите Id для удаления: ")
                                .hasChecker(id -> id > 0)
                                .hasParser(Integer::parseInt)
                                .readCycle())
                        .ifPresentOrElse(
                                furniture -> furnitureDao.removeById(furniture.getId()),
                                () -> System.out.println("Нет такой записи")
                        );
                case 5 -> furnitureDao
                        .findByType(new ReadWithCheckBuilder<String>()
                                .hasMessage("Введите тип для поиска: ")
                                .hasChecker(string -> !string.isBlank())
                                .readCycle()
                        )
                        .forEach(System.out::println);
                case 6 -> furnitureDao
                        .findById(new ReadWithCheckBuilder<Integer>()
                                .hasMessage("Введите Id записи: ")
                                .hasChecker(id -> id > 0)
                                .hasParser(Integer::parseInt)
                                .readCycle())
                        .ifPresentOrElse(
                                System.out::println,
                                () -> System.out.println("Нет такой записи")
                        );
                case 0 -> {
                    return;
                }
            }
        }
    }

    private Furniture furnitureFromInput() {
        return new Furniture(
                new ReadWithCheckBuilder<String>()
                        .hasMessage("Введите тип: ")
                        .hasChecker(string -> !string.isBlank())
                        .readCycle(),
                new ReadWithCheckBuilder<String>()
                        .hasMessage("Введите модель: ")
                        .hasChecker(string -> !string.isBlank())
                        .readCycle(),
                new ReadWithCheckBuilder<String>()
                        .hasMessage("Введите производителя: ")
                        .hasChecker(string -> !string.isBlank())
                        .readCycle(),
                BigDecimal.valueOf(new ReadWithCheckBuilder<Integer>()
                        .hasMessage("Введите цену (целая часть, рубли): ")
                        .hasChecker(number -> 0 < number)
                        .hasParser(Integer::parseInt)
                        .readCycle() +
                        new ReadWithCheckBuilder<Integer>()
                                .hasMessage("Введите цену (копейки): ")
                                .hasChecker(number -> 0 < number && number < 100)
                                .hasParser(Integer::parseInt)
                                .readCycle() / 100.0),
                new ReadWithCheckBuilder<Double>()
                        .hasMessage("Введите высоту (сантиметры): ")
                        .hasChecker(number -> 0 < number && number < 10000)
                        .hasParser(Double::parseDouble)
                        .readCycle()
        );
    }
}
