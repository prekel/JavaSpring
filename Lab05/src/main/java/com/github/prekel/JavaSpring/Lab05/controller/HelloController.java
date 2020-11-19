package com.github.prekel.JavaSpring.Lab05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String showHelloPage(@RequestParam(value = "name", required = false, defaultValue = "незнакомец") String name, Model model) {
        model.addAttribute("message", "Привет, " + name + "!");
        return "hello";
    }
}
