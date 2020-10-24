package com.github.prekel.JavaSpring.Lab04;

public interface Parser<T> {
    T parse(String str);
}

class DoubleParser implements Parser<Double>
{
    @Override
    public Double parse(String str) {
        return Double.parseDouble(str);
    }
}
