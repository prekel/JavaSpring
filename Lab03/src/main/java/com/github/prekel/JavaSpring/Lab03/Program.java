package com.github.prekel.JavaSpring.Lab03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.prekel.JavaSpring.Lab03.components.PersonalComputer;

public class Program {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        var pc1 = context.getBean("pc1", PersonalComputer.class);
        var pc2 = context.getBean("pc2", PersonalComputer.class);
        var pc3 = context.getBean("pc3", PersonalComputer.class);
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
