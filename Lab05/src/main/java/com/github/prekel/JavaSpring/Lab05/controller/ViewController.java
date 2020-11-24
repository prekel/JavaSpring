package com.github.prekel.JavaSpring.Lab05.controller;

import com.github.prekel.JavaSpring.Lab05.data.FurnitureDao;
import com.github.prekel.JavaSpring.Lab05.form.IdForm;
import com.github.prekel.JavaSpring.Lab05.form.TypeForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/view")
public class ViewController {
    private final FurnitureDao furnitureDao;

    public ViewController(@Qualifier("furnitureRepository") FurnitureDao furnitureDao) {
        this.furnitureDao = furnitureDao;
    }

    @GetMapping
    public String viewByIdOrAll(Model model) {
        model.addAttribute("idForm", new IdForm());
        model.addAttribute("typeForm", new TypeForm());

        var furnitures = furnitureDao.findAll();
        model.addAttribute("furnitures", furnitures);
        return "view";
    }

    @GetMapping(params = "id")
    public String viewByIdOrAll(@Valid IdForm idForm, BindingResult bindingResultIdForm, TypeForm typeForm, Model model) {
        if (bindingResultIdForm.hasErrors()) {
            return "view";
        }
        if (idForm.getId() == 0) {
            return "redirect:/view";
        }
        var furnitures = furnitureDao.findById(idForm.getId()).stream().collect(Collectors.toList());
        model.addAttribute("furnitures", furnitures);
        return "view";
    }

    @GetMapping(params = "type")
    public String viewByType(@Valid TypeForm typeForm, BindingResult bindingResultTypeForm, IdForm idForm, Model model) {
        if (bindingResultTypeForm.hasErrors()) {
            return "view";
        }
        var furnitures = furnitureDao.findByType(typeForm.getType());
        model.addAttribute("furnitures", furnitures);
        return "view";
    }
}
