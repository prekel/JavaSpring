package com.github.prekel.JavaSpring.Lab03.tests;

import com.github.prekel.JavaSpring.Lab03.Config;
import com.github.prekel.JavaSpring.Lab03.components.PersonalComputer;
import com.github.prekel.JavaSpring.Lab03.components.UnlockedCpu;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonalComputerTests {
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    @Test
    public void pc1Test() {
        var pc1 = context.getBean("pc1", PersonalComputer.class);
        var cpu1 = pc1.getCpu();
        assertEquals(3600, cpu1.getClock());
        assertEquals("Pc with cpu1", pc1.getName());
    }

    @Test
    public void pc2Test() {
        var pc2 = context.getBean("pc2", PersonalComputer.class);
        var cpu2 = pc2.getCpu();
        assertEquals(2600, cpu2.getClock());
        assertEquals("Pc with cpu2", pc2.getName());
    }

    @Test
    public void pc3Test() {
        var pc3 = context.getBean("pc3", PersonalComputer.class);
        var cpu3 = pc3.getCpu();
        var unlockedCpu3 = (UnlockedCpu) cpu3;
        assertEquals(4000, cpu3.getClock());
        assertEquals(100, unlockedCpu3.getBusClock());
        assertEquals(40, unlockedCpu3.getMultiplier());
        assertEquals("Pc with cpu3", pc3.getName());
    }

    @Test
    public void pc4Test() {
        var pc4 = context.getBean("pc4", PersonalComputer.class);
        var cpu4 = pc4.getCpu();
        var unlockedCpu4 = (UnlockedCpu) cpu4;
        assertEquals(2200, cpu4.getClock());
        assertEquals(110, unlockedCpu4.getBusClock());
        assertEquals(20, unlockedCpu4.getMultiplier());
        assertEquals("Pc with cpu4", pc4.getName());
    }

    @Test
    public void pcAsComponentTest() {
        var pc = context.getBean("pcAsComponent", PersonalComputer.class);
        var cpu1 = pc.getCpu();
        assertEquals(3600, cpu1.getClock());
        assertEquals("Default PC name", pc.getName());
    }

    @Test
    public void pcFromFabricMethodTest() {
        var pcf = context.getBean("pcFromFabricMethod", PersonalComputer.class);
        var cpu4 = pcf.getCpu();
        var unlockedCpu4 = (UnlockedCpu) cpu4;
        assertEquals(2200, cpu4.getClock());
        assertEquals(110, unlockedCpu4.getBusClock());
        assertEquals(20, unlockedCpu4.getMultiplier());
        assertEquals("Pc from fabric method", pcf.getName());
    }
}
