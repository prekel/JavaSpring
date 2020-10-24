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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.function.Function;

@SpringBootApplication
public class Program implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(Program.class);
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private FurnitureDao furnitureDao;

    public static void main(String[] args) {
        LOG.info("Started");
        SpringApplication.run(Program.class, args);
        LOG.info("Ended");
    }

    @Override
    public void run(String... args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        furnitureDao = ReadIntWithCheck("1 - JdbcTemplate, 2 - JpaRepository: ", reader, number -> 1 <= number && number <= 2) == 1
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
            switch (ReadIntWithCheck("Введите номер команды: ", reader, number -> 0 <= number && number <= 6)) {
                case 1 -> furnitureDao
                        .insert(FurnitureFromInput(reader, new Furniture()));
                case 2 -> furnitureDao
                        .findAll()
                        .forEach(System.out::println);
                case 3 -> furnitureDao
                        .findById(ReadIntWithCheck("Введите Id для редактирования: ", reader, id -> id > 0))
                        .ifPresent(furniture -> furnitureDao.insert(FurnitureFromInput(reader, furniture)));
                case 4 -> furnitureDao
                        .findById(ReadIntWithCheck("Введите Id для удаления: ", reader, id -> id > 0))
                        .ifPresent(furniture -> furnitureDao.removeById(furniture.getId()));
                case 5 -> furnitureDao
                        .findByType(ReadStringWithCheck("Введите тип для поиска: ", reader, Program::CheckString))
                        .forEach(System.out::println);
                case 6 -> furnitureDao
                        .findById(ReadIntWithCheck("Введите Id записи: ", reader, id -> id > 0))
                        .ifPresent(System.out::println);
                case 0 -> {
                    System.out.println();
                    return;
                }
            }
        }
    }

    private Furniture FurnitureFromInput(BufferedReader reader, Furniture furniture) {
        furniture.setType(ReadStringWithCheck("Введите тип: ", reader, Program::CheckString));
        furniture.setModel(ReadStringWithCheck("Введите модель: ", reader, Program::CheckString));
        furniture.setManufacturer(ReadStringWithCheck("Введите производителя: ", reader, Program::CheckString));
        var roubles = ReadIntWithCheck("Введите цену (целая часть, рубли): ", reader, number -> 0 < number);
        var cents = ReadIntWithCheck("Введите цену (копейки): ", reader, number -> 0 < number && number < 100);
        furniture.setCost(new BigDecimal(roubles + "." + cents));
        furniture.setHeight(ReadDoubleWithCheck("Введите высоту (сантиметры): ", reader, number -> 0 < number && number < 10000));
        return furniture;
    }

    private static boolean CheckString(String string) {
        return string != null && !string.isBlank();
    }

    private static int ReadIntWithCheck(String message, BufferedReader
            reader, Function<Integer, Boolean> checker) {
        while (true) {
            try {
                System.out.print(message);
                var number = Integer.parseInt(reader.readLine());
                if (!checker.apply(number)) {
                    throw new Exception("Не в промежутке");
                }
                return number;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static String ReadStringWithCheck(String message, BufferedReader
            reader, Function<String, Boolean> checker) {
        while (true) {
            try {
                System.out.print(message);
                var string = reader.readLine();
                if (!checker.apply(string)) {
                    throw new Exception("Пустая строка");
                }
                return string;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static double ReadDoubleWithCheck(String message, BufferedReader
            reader, Function<Double, Boolean> checker) {
        while (true) {
            try {
                System.out.print(message);
                var number = Double.parseDouble(reader.readLine());
                if (!checker.apply(number)) {
                    throw new Exception("Не в промежутке");
                }
                return number;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
