package com.github.prekel.JavaSpring.Lab05;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Function;

public class ReadWithCheckBuilder<T> {
    private final BufferedReader reader;
    private String message = "";
    private Function<String, T> parser = (s -> (T) s);
    private Function<T, Boolean> checker = (obj -> true);

    public ReadWithCheckBuilder() {
        this(System.in);
    }

    public ReadWithCheckBuilder(InputStream in) {
        this(new BufferedReader(new InputStreamReader(in)));
    }

    public ReadWithCheckBuilder(BufferedReader reader) {
        this.reader = reader;
    }

    public ReadWithCheckBuilder<T> hasMessage(String message) {
        this.message = message;
        return this;
    }

    public ReadWithCheckBuilder<T> hasParser(Function<String, T> parser) {
        this.parser = parser;
        return this;
    }

    public ReadWithCheckBuilder<T> hasChecker(Function<T, Boolean> checker) {
        this.checker = checker;
        return this;
    }

    public T readCycle() {
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
