package com.github.prekel.JavaSpring.Lab05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/furnitures")
public class FurnituresController {
    @GetMapping("")
    public String furnitures() {
        return "furnitures";
    }
}
