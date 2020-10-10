package com.github.prekel.JavaSpring.Lab02.components;

public class UnlockedCpu implements Cpu {
    private final int busClock;
    private int multiplier;

    @Override
    public String toString() {
        return "com.github.prekel.JavaSpring.Lab02.components.UnlockedCpu{" +
                "busClock=" + busClock +
                ", multiplier=" + multiplier +
                ", clock=" + getClock() +
                '}';
    }

    public UnlockedCpu(int busClock, int multiplier) {
        this.busClock = busClock;
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public int getClock() {
        return busClock * multiplier;
    }

    public int getBusClock() {
        return busClock;
    }
}
