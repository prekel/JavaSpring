package com.github.prekel.JavaSpring.Lab06.controller;

import com.github.prekel.JavaSpring.Lab06.Lab06Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
    private static final Logger LOG = LoggerFactory.getLogger(Lab06Application.class);

    @GetMapping
    public String showError() {

        return "error";
    }

    @PostMapping
    public String errorConfirm() {

        return "redirect:/";
    }
}
