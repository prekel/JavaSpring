package com.github.prekel.JavaSpring.Lab04;

import java.io.BufferedReader;
import java.util.function.Function;

public class ReadBuilder<T> {
    private String message = "";
    private Parser<T> parser;
    private Function<T, Boolean> checker;
    private BufferedReader reader;

    public ReadBuilder(ReaderWithCheck reader) {

    }

    public ReadBuilder<T> HasMessage(String message) {
        this.message = message;
        return this;
    }

    public ReadBuilder<T> HasParser(Function<String, T> parser) {
        this.parser = parser::apply;
        return this;
    }

    public ReadBuilder<T> HasChecker(Function<T, Boolean> checker) {
        this.checker = checker;
        return this;
    }

    public T Read() {
        return ReadWithCheck(message, parser::parse, checker);
    }

    public <T> T ReadWithCheck(String message, Function<String, T> parser, Function<T, Boolean> checker) {
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
