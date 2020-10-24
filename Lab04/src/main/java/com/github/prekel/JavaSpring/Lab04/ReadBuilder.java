package com.github.prekel.JavaSpring.Lab04;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Function;

public class ReadBuilder<T> {
    private String message = "";
    private Function<String, T> parser;
    private Function<T, Boolean> checker;
    private final BufferedReader reader;

    public ReadBuilder() {
        this(System.in);
    }

    public ReadBuilder(InputStream in) {
        this(new BufferedReader(new InputStreamReader(in)));
    }

    public ReadBuilder(BufferedReader reader) {
        this.reader = reader;
    }

    public ReadBuilder<T> HasMessage(String message) {
        this.message = message;
        return this;
    }

    public ReadBuilder<T> HasParser(Function<String, T> parser) {
        this.parser = parser;
        return this;
    }

    public ReadBuilder<T> HasChecker(Function<T, Boolean> checker) {
        this.checker = checker;
        return this;
    }

    public T Read() {
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
}
