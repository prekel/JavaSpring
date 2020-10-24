package com.github.prekel.JavaSpring.Lab04;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Function;

public class ReaderWithCheck {
    private final BufferedReader reader;

    public ReaderWithCheck() {
        this(System.in);
    }

    public ReaderWithCheck(InputStream in) {
        this(new BufferedReader(new InputStreamReader(in)));
    }

    public ReaderWithCheck(BufferedReader reader) {
        this.reader = reader;
    }

    public int readIntWithCheck(String message, Function<Integer, Boolean> checker) {
        return readWithCheck(message, Integer::parseInt, checker);
    }

    public <T> T readWithCheck(String message, Function<String, T> parser, Function<T, Boolean> checker) {
        while (true) {
            System.out.print(message);
            try {
                var parsed = parser.apply(reader.readLine());
                if (!checker.apply(parsed)) {
                    throw new Exception("Не в промежутке или пустая строка");
                }
                return parsed;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public String readStringWithCheck(String message, Function<String, Boolean> checker) {
        return readWithCheck(message, s -> s, checker);
    }

    public double readDoubleWithCheck(String message, Function<Double, Boolean> checker) {
        return readWithCheck(message, Double::parseDouble, checker);
    }
}
