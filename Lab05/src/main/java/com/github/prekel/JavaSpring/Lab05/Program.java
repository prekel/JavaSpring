package com.github.prekel.JavaSpring.Lab05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("com.github.prekel.JavaSpring.Lab05.controller")
public class Program {
    private static final Logger LOG = LoggerFactory.getLogger(Program.class);

    public static void main(String[] args) {
        LOG.info("Started");
        SpringApplication.run(Program.class, args);
        LOG.info("Ended");
    }
}
