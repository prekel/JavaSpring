package com.github.prekel.JavaSpring.Lab06.controller;

import com.github.prekel.JavaSpring.Lab06.data.FurnitureDao;
import com.github.prekel.JavaSpring.Lab06.entity.Furniture;
import com.github.prekel.JavaSpring.Lab06.form.FurnitureForm;
import com.github.prekel.JavaSpring.Lab06.form.IdForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/edit")
public class EditController {
    private final FurnitureDao furnitureDao;

    public EditController(@Qualifier("furnitureRepository") FurnitureDao furnitureDao) {
        this.furnitureDao = furnitureDao;
    }

    @GetMapping
    public String getForm(Model model) {
        model.addAttribute("idForm", new IdForm());
        model.addAttribute("furnitureForm", new FurnitureForm());
        return "/WEB-INF/views/edit.html";
    }

    @GetMapping(params = "id")
    public String fillById(@Valid IdForm idForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("furnitureForm", new FurnitureForm());
            return "/WEB-INF/views/edit.html";
        }
        if (furnitureDao.findById(idForm.getId()).isEmpty()) {
            model.addAttribute("notFound", true);
            model.addAttribute("furnitureForm", new FurnitureForm());
            return "/WEB-INF/views/edit.html";
        }
        var form = new FurnitureForm();
        form.setId(idForm.getId());
        var f = furnitureDao.findById(idForm.getId()).get();
        form.setType(f.getType());
        form.setModel(f.getModel());
        form.setManufacturer(f.getManufacturer());
        form.setCost(f.getCost());
        form.setHeight(f.getHeight());
        model.addAttribute("furnitureForm", form);
        return "/WEB-INF/views/edit.html";
    }

    @PostMapping
    public String editByForm(@Valid FurnitureForm furnitureForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/WEB-INF/views/edit.html";
        }
        if (furnitureDao.findById(furnitureForm.getId()).isEmpty()) {
            model.addAttribute("notFound", true);
            return "/WEB-INF/views/edit.html";
        }
        furnitureDao.updateById(furnitureForm.getId(), new Furniture(furnitureForm.getType(), furnitureForm.getModel(),
                furnitureForm.getManufacturer(), furnitureForm.getCost(), furnitureForm.getHeight()));
        return "redirect:/view?id=" + furnitureForm.getId();
    }
}
