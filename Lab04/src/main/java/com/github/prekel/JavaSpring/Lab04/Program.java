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
        furnitureDao = reader.ReadIntWithCheck("1 - JdbcTemplate, 2 - JpaRepository: ", number -> 1 <= number && number <= 2) == 1
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
            var t = new ReadBuilder<Double>(reader)
                    .HasMessage("Введите номер команды1: ")
                    .HasChecker(number -> 0 <= number && number <= 6)
                    .HasParser(Double::parseDouble)
                    .Read();
            switch (reader.ReadIntWithCheck("Введите номер команды: ", number -> 0 <= number && number <= 6)) {
                case 1 -> furnitureDao
                        .insert(FurnitureFromInput(new Furniture()));
                case 2 -> furnitureDao
                        .findAll()
                        .forEach(System.out::println);
                case 3 -> furnitureDao
                        .findById(reader.ReadIntWithCheck("Введите Id для редактирования: ", id -> id > 0))
                        .ifPresent(furniture -> furnitureDao.insert(FurnitureFromInput(furniture)));
                case 4 -> furnitureDao
                        .findById(reader.ReadIntWithCheck("Введите Id для удаления: ", id -> id > 0))
                        .ifPresent(furniture -> furnitureDao.removeById(furniture.getId()));
                case 5 -> furnitureDao
                        .findByType(reader.ReadStringWithCheck("Введите тип для поиска: ", string -> !string.isBlank()))
                        .forEach(System.out::println);
                case 6 -> furnitureDao
                        .findById(reader.ReadIntWithCheck("Введите Id записи: ", id -> id > 0))
                        .ifPresent(System.out::println);
                case 0 -> {
                    System.out.println();
                    return;
                }
            }
        }
    }

    private Furniture FurnitureFromInput(Furniture furniture) {
        furniture.setType(reader.ReadStringWithCheck("Введите тип: ", string2 -> !string2.isBlank()));
        furniture.setModel(reader.ReadStringWithCheck("Введите модель: ", string1 -> !string1.isBlank()));
        furniture.setManufacturer(reader.ReadStringWithCheck("Введите производителя: ", string -> !string.isBlank()));
        var roubles = reader.ReadIntWithCheck("Введите цену (целая часть, рубли): ", number -> 0 < number);
        var cents = reader.ReadIntWithCheck("Введите цену (копейки): ", number -> 0 < number && number < 100);
        furniture.setCost(new BigDecimal(roubles + "." + cents));
        furniture.setHeight(reader.ReadDoubleWithCheck("Введите высоту (сантиметры): ", number -> 0 < number && number < 10000));
        return furniture;
    }
}
