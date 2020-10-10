package com.github.prekel.JavaSpring.Lab02.components;

public class LockedCpu implements Cpu {
    private final int clock;

    @Override
    public String toString() {
        return "LockedCpu{" +
                "clock=" + clock +
                '}';
    }

    public LockedCpu(int clock) {
        this.clock = clock;
    }

    @Override
    public int getClock() {
        return clock;
    }
}
