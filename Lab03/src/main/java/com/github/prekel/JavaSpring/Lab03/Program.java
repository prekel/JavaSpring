package com.github.prekel.JavaSpring.Lab03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);


        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        //var pc1 = context.getBean("pc1", com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.PersonalComputer.class);
        //var pc2 = context.getBean("pc2", com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.PersonalComputer.class);
        //var pc3 = context.getBean("pc3", com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.PersonalComputer.class);
        //var pc4 = context.getBean("pc4", com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.PersonalComputer.class);
        //var pc = context.getBean("pcAsComponent", com.github.prekel.JavaSpring.Lab03.components.com.github.prekel.JavaSpring.Lab02.components.PersonalComputer.class);
        //System.out.println(pc1);
        //System.out.println(pc2);
        //System.out.println(pc3);
        //System.out.println(pc4);
        //System.out.println(pc);

        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        context.close();
    }
}
