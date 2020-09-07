import entities.Computer;
import entities.Laptop;
import entities.PersonalComputer;
import entities.Tablet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Function;


public class Program {
    private static final ArrayList<Computer> ComputerList = new ArrayList<>();

    public static void main(String[] args) {

        var reader = new BufferedReader(new InputStreamReader(System.in));

        boolean needBreak = false;
        while (!needBreak) {
            System.out.println("1 - Добавить элемент класса Computer");
            System.out.println("2 - Добавить элемент класса PersonalComputer");
            System.out.println("3 - Добавить элемент класса Laptop");
            System.out.println("4 - Добавить элемент класса Tablet");
            System.out.println("5 - Удалить элемент по индексу");
            System.out.println("6 - Сравнение двух элементов на равенство (по индексам)");
            System.out.println("7 - Печать всех элементов");
            System.out.println("8 - Завершение работы приложения");

            var cmdNumber = ReadIntWithCheck("Введите номер команды: ", reader, Program::CheckCmd);

            switch (cmdNumber) {
                case 1: {
                    var field1 = ReadIntWithCheck("Введите Field1 класса Computer: ", reader, Program::CheckInt);
                    var name = ReadStringWithCheck("Введите Name класса Computer: ", reader, Program::CheckString);

                    getComputerList().add(new Computer(field1, name));
                    break;
                }
                case 2: {
                    var field1 = ReadIntWithCheck("Введите Field1 класса PersonalComputer: ", reader, Program::CheckInt);
                    var field2 = ReadIntWithCheck("Введите Field2 класса PersonalComputer: ", reader, Program::CheckInt);
                    var name = ReadStringWithCheck("Введите Name класса PersonalComputer: ", reader, Program::CheckString);
                    var name2 = ReadStringWithCheck("Введите Name2 класса PersonalComputer: ", reader, Program::CheckString);

                    getComputerList().add(new PersonalComputer(field1, field2, name, name2));
                    break;
                }
                case 3: {
                    var field1 = ReadIntWithCheck("Введите Field1 класса Laptop: ", reader, Program::CheckInt);
                    var field2 = ReadIntWithCheck("Введите Field2 класса Laptop: ", reader, Program::CheckInt);
                    var field3 = ReadIntWithCheck("Введите Field3 класса Laptop: ", reader, Program::CheckInt);
                    var name = ReadStringWithCheck("Введите Name класса Laptop: ", reader, Program::CheckString);
                    var name2 = ReadStringWithCheck("Введите Name2 класса Laptop: ", reader, Program::CheckString);
                    var name3 = ReadStringWithCheck("Введите Name3 класса Laptop: ", reader, Program::CheckString);

                    getComputerList().add(new Laptop(field1, field2, field3, name, name2, name3));
                    break;
                }
                case 4: {
                    var field1 = ReadIntWithCheck("Введите Field1 класса Tablet: ", reader, Program::CheckInt);
                    var field2 = ReadIntWithCheck("Введите Field2 класса Tablet: ", reader, Program::CheckInt);
                    var field4 = ReadIntWithCheck("Введите Field4 класса Tablet: ", reader, Program::CheckInt);
                    var name = ReadStringWithCheck("Введите Name класса Tablet: ", reader, Program::CheckString);
                    var name2 = ReadStringWithCheck("Введите Name2 класса Tablet: ", reader, Program::CheckString);
                    var name4 = ReadStringWithCheck("Введите Name4 класса Tablet: ", reader, Program::CheckString);
                    var tablet = new Tablet(field1, field2, field4, name, name2, name4);
                    getComputerList().add(tablet);
                    break;
                }
                case 5: {
                    var indexToDelete = ReadIntWithCheck("Введите индекс для удаления: ", reader, Program::CheckIndex);
                    getComputerList().remove(indexToDelete);
                    break;
                }
                case 6: {
                    var index1ToCompare = ReadIntWithCheck("Введите первый индекс для сравнения: ", reader, Program::CheckIndex);
                    var index2ToCompare = ReadIntWithCheck("Введите второй индекс для сравнения: ", reader, Program::CheckIndex);
                    if (getComputerList().get(index1ToCompare).equals(getComputerList().get(index2ToCompare))) {
                        System.out.println("Объекты равны");
                    } else {
                        System.out.println("Объекты не равны");
                    }
                    break;
                }
                case 7: {
                    for (var i : getComputerList()) {
                        System.out.println(i);
                    }
                    break;
                }
                case 8: {
                    needBreak = true;
                    break;
                }
            }

            System.out.println();
        }
    }

    private static int ReadIntWithCheck(String message, BufferedReader reader, Function<Integer, Boolean> checker) {
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

    private static boolean CheckCmd(int number) {
        return 1 <= number && number <= 8;
    }

    private static boolean CheckInt(int number) {
        return 0 <= number && number < 1000;
    }

    private static String ReadStringWithCheck(String message, BufferedReader reader, Function<String, Boolean> checker) {
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

    private static boolean CheckString(String string) {
        return string != null && !string.isBlank();
    }

    public static ArrayList<Computer> getComputerList() {
        return ComputerList;
    }

    private static boolean CheckIndex(int number) {
        return 0 <= number && number < getComputerList().size();
    }
}
