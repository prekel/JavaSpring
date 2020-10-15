package com.github.prekel.JavaSpring.Lab03;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.prekel.JavaSpring.Lab03.components.PersonalComputer;

public class Program {
    public static void main(String[] args) {
        //SpringApplication.run(Program.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        var config = context.getBean("config", Config.class);

        var pc1 = config.pc1();
        var pc2 = config.pc2();
        var pc3 = config.pc3();
        var pc4 = context.getBean("pc4", PersonalComputer.class);
        var pc = context.getBean("pcAsComponent", PersonalComputer.class);
        var pcf = context.getBean("pcFromFabricMethod", PersonalComputer.class);
        System.out.println(pc1);
        System.out.println(pc2);
        System.out.println(pc3);
        System.out.println(pc4);
        System.out.println(pc);
        System.out.println(pcf);

        System.out.println();

        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        context.close();
    }
}
