package com.github.prekel.JavaSpring.Lab03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:pc4.properties")
@ComponentScan("com.github.prekel.JavaSpring.Lab03.components")
public class SpringConfig {
//    @Value("${pc4.name}")
//    private String volume;
//
//    @Bean("pc1")
//    public com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.PersonalComputer pc1() {
//        return new com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.PersonalComputer(cpu1(), "Pc with cpu1");
//    }
//
//    @Bean("cpu1")
//    public com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.Cpu cpu1() {
//        return new com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.LockedCpu(3600);
//    }
//
//    @Bean("pc2")
//    public com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.PersonalComputer pc2() {
//        return new com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.PersonalComputer(cpu2(), "Pc with cpu2");
//    }
//
//    @Bean("cpu2")
//    public com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.Cpu cpu2() {
//        return new com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.LockedCpu(2600);
//    }
//
//    @Bean("pc3")
//    public com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.PersonalComputer pc3() {
//        var ret = new com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.PersonalComputer(cpu3());
//        ret.setName("Pc with cpu3");
//        return ret;
//    }
//
//    @Bean("cpu3")
//    public com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.Cpu cpu3() {
//        return new com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.UnlockedCpu(100, 40);
//    }
//
//    @Bean("pc4")
//    public com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.PersonalComputer pc4() {
//        var ret = new com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.PersonalComputer(cpu4());
//        ret.setName(volume);
//        return ret;
//    }
//
//    @Bean("cpu4")
//    public com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.Cpu cpu4() {
//        return new com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.UnlockedCpu(110, 20);
//    }
}
