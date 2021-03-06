package com.github.prekel.JavaSpring.Lab07.controller;


import com.github.prekel.JavaSpring.Lab07.data.FurnitureDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
    private final FurnitureDao furnitureDao;

    public IndexController(@Qualifier("furnitureJdbcDao") FurnitureDao furnitureDao) {
        this.furnitureDao = furnitureDao;
    }

    @GetMapping
    public String showHomePage(Model model) {
        model.addAttribute("count", furnitureDao.count());
        return "index";
    }
}
