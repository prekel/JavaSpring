package com.github.prekel.JavaSpring.Lab06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping
    public String showError() {

        return "error";
    }

    @PostMapping
    public String errorConfirm() {

        return "redirect:/";
    }
}
