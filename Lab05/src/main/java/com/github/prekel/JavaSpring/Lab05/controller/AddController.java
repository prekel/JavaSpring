package com.github.prekel.JavaSpring.Lab05.controller;

import com.github.prekel.JavaSpring.Lab05.component.FurnitureDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

class FurnitureForm {
    //@NotNull(message = "Поле не должно быть пустым")
    @Min(value = 10, message = "Поле не должно быть пустым")
    @Max(value = 100, message = "Поле не должно быть пустым")
    private int id;
    //@NotNull(message = "Поле не должно быть пустым")
    @NotBlank(message = "Поле не должно быть пустым")
    private String type;
    //@NotNull(message = "Поле не должно быть пустым")
    private String model;
    //@NotNull(message = "Поле не должно быть пустым")
    private String manufacturer;
    //@NotNull(message = "Поле не должно быть пустым")
    private BigDecimal cost;
    //@NotNull(message = "Поле не должно быть пустым")
    private double height;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

@Controller
@RequestMapping("/add")
public class AddController {
    private final FurnitureDao furnitureDao;

    public AddController(@Qualifier("furnitureRepository") FurnitureDao furnitureDao) {
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
        model.addAttribute("furnitureForm", furnitureForm);
        return "result";
    }
}
