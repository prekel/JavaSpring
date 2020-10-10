package com.github.prekel.JavaSpring.Lab03.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("pcAsComponent")
public class PersonalComputer {
    private final Cpu cpu;
    private String name = "Default PC name";

    @Autowired
    public PersonalComputer(@Qualifier("cpu1") Cpu cpu) {
        this.cpu = cpu;
    }

    public PersonalComputer(Cpu cpu, String name) {
        this.cpu = cpu;
        this.name = name;
    }

    @Bean("pcFromFabricMethod")
    public static PersonalComputer pcFromFabricMethod(@Qualifier("cpu4") Cpu cpu) {
        return new PersonalComputer(cpu, "Pc from fabric method");
    }

    public void turnOn() {
        System.out.println("Включен " + toString());
    }

    @Override
    public String toString() {
        return "PersonalComputer{" +
                "cpu=" + cpu +
                ", name='" + name + '\'' +
                '}';
    }

    public void turnOff() {
        System.out.println("Выключен " + toString());
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
