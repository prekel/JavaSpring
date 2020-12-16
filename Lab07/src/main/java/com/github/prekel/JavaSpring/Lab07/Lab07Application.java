package com.github.prekel.JavaSpring.Lab07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab07Application {
    private static final Logger LOG = LoggerFactory.getLogger(Lab07Application.class);

    public static void main(String[] args) {
        LOG.info("Started");
        SpringApplication.run(Lab07Application.class, args);
        LOG.info("Ended");
    }
}
