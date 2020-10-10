package com.github.prekel.JavaSpring.Lab03.components;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PersonalComputer {
    private final Cpu cpu;
    private String name = "Default PC name";

    @Override
    public String toString() {
        return "com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.PersonalComputer{" +
                "cpu=" + cpu +
                ", name='" + name + '\'' +
                '}';
    }

    public PersonalComputer()
    {
        cpu = null;
    }

    public PersonalComputer(@Qualifier("cpu1") Cpu cpu) {
        this.cpu = cpu;
    }

    public PersonalComputer(Cpu cpu, String name) {
        this.cpu = cpu;
        this.name = name;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
