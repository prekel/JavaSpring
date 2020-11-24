package com.github.prekel.JavaSpring.Lab05.controller;

import com.github.prekel.JavaSpring.Lab05.data.FurnitureDao;
import com.github.prekel.JavaSpring.Lab05.entity.Furniture;
import com.github.prekel.JavaSpring.Lab05.form.FurnitureForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/add")
public class AddController {
    private final FurnitureDao furnitureDao;

    public AddController(@Qualifier("furnitureJdbcDao") FurnitureDao furnitureDao) {
        this.furnitureDao = furnitureDao;
    }

    @GetMapping
    public String createStudent(Model model) {
        model.addAttribute("furnitureForm", new FurnitureForm());
        return "add";
    }

    @PostMapping
    public String greetingSubmit(@Valid FurnitureForm furnitureForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        var id = furnitureDao.insert(new Furniture(furnitureForm.getType(), furnitureForm.getModel(),
                furnitureForm.getManufacturer(), furnitureForm.getCost(), furnitureForm.getHeight()));
        return "redirect:/view?id=" + id;
    }
}
