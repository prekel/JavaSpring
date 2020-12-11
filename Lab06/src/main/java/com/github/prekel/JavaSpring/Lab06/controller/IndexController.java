package com.github.prekel.JavaSpring.Lab06.controller;


import com.github.prekel.JavaSpring.Lab06.data.FurnitureDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    private final FurnitureDao furnitureDao;

    public IndexController(@Qualifier("furnitureJdbcDao") FurnitureDao furnitureDao) {
        this.furnitureDao = furnitureDao;
    }

    @GetMapping
    public String showHomePage(Model model) {
        model.addAttribute("count", furnitureDao.count());
        return "index";
    }

    @GetMapping("/admin")
    public String privateHome() {
        return "private";
    }
}
