package com.github.prekel.JavaSpring.Lab05.controller;

import com.github.prekel.JavaSpring.Lab05.component.FurnitureDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/furnitures")
public class FurnituresController {
    private final FurnitureDao furnitureDao;

    public FurnituresController(@Qualifier("furnitureRepository") FurnitureDao furnitureDao) {
        this.furnitureDao = furnitureDao;
    }

//    @GetMapping
//    public String furnitures(Model model) {
//        model.addAttribute("furnitures", furnitureDao.findAll());
//        return "furnitures";
//    }


    @GetMapping("/all")
    public String furnitures(Model model) {
        var furnitures= furnitureDao.findAll();
        model.addAttribute("furnitures", furnitures);
        return "furnitures";
    }

    @GetMapping
    public String furnitures(Optional<Integer> id, Model model) {
        var furnitures = id
                .map(integer -> furnitureDao.findById(integer).stream().collect(Collectors.toList()))
                .orElseGet(furnitureDao::findAll);
        model.addAttribute("furnitures", furnitures);
        return "furnitures";
    }
}
