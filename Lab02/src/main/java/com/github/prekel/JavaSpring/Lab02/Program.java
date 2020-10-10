package com.github.prekel.JavaSpring.Lab02;

import com.github.prekel.JavaSpring.Lab02.components.PersonalComputer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("applicationContext.xml");
        var pc1 = context.getBean("pc1", PersonalComputer.class);
        var pc2 = context.getBean("pc2", PersonalComputer.class);
        var pc3 = context.getBean("pc3", PersonalComputer.class);
        var pc4 = context.getBean("pc4", PersonalComputer.class);
        System.out.println(pc1);
        System.out.println(pc2);
        System.out.println(pc3);
        System.out.println(pc4);

        System.out.println();

        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        context.close();
    }
}
