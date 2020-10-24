package com.github.prekel.JavaSpring.Lab04;

import com.github.prekel.JavaSpring.Lab04.component.FurnitureDao;
import com.github.prekel.JavaSpring.Lab04.component.FurnitureJdbcDao;
import com.github.prekel.JavaSpring.Lab04.component.FurnitureRepository;
import com.github.prekel.JavaSpring.Lab04.entity.Furniture;
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
    private final ReaderWithCheck reader = config.readerWithCheck();
    private FurnitureDao furnitureDao;

    public static void main(String[] args) {
        LOG.info("Started");
        SpringApplication.run(Program.class, args);
        LOG.info("Ended");
    }

    @Override
    public void run(String... args) throws Exception {
        furnitureDao = reader.readIntWithCheck("1 - JdbcTemplate, 2 - JpaRepository: ", number -> 1 <= number && number <= 2) == 1
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
            switch (reader.readIntWithCheck("Введите номер команды: ", number -> 0 <= number && number <= 6)) {
                case 1 -> furnitureDao
                        .insert(furnitureFromInput());
                case 2 -> furnitureDao
                        .findAll()
                        .forEach(System.out::println);
                case 3 -> furnitureDao
                        .findById(reader.readIntWithCheck("Введите Id для редактирования: ", id -> id > 0))
                        .ifPresentOrElse(
                                furniture -> furnitureDao.updateById(furniture.getId(), furnitureFromInput()),
                                () -> System.out.println("Нет такой записи")
                        );
                case 4 -> furnitureDao
                        .findById(reader.readIntWithCheck("Введите Id для удаления: ", id -> id > 0))
                        .ifPresentOrElse(
                                furniture -> furnitureDao.removeById(furniture.getId()),
                                () -> System.out.println("Нет такой записи")
                        );
                case 5 -> furnitureDao
                        .findByType(reader.readStringWithCheck("Введите тип для поиска: ", string -> !string.isBlank()))
                        .forEach(System.out::println);
                case 6 -> furnitureDao
                        .findById(reader.readIntWithCheck("Введите Id записи: ", id -> id > 0))
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

    private Furniture furnitureFromInput()
    {
        return new Furniture(
                reader.readStringWithCheck("Введите тип: ", string2 -> !string2.isBlank()),
                reader.readStringWithCheck("Введите модель: ", string1 -> !string1.isBlank()),
                reader.readStringWithCheck("Введите производителя: ", string -> !string.isBlank()),
                BigDecimal.valueOf(reader.readIntWithCheck("Введите цену (целая часть, рубли): ", number1 -> 0 < number1) +
                        reader.readIntWithCheck("Введите цену (копейки): ", number2 -> 0 < number2 && number2 < 100) / 100.0),
                reader.readDoubleWithCheck("Введите высоту (сантиметры): ", number -> 0 < number && number < 10000)
        );
    }
}
