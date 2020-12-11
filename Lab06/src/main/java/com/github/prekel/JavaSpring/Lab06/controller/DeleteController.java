package com.github.prekel.JavaSpring.Lab06.controller;

import com.github.prekel.JavaSpring.Lab06.data.FurnitureDao;
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
@RequestMapping("/delete")
public class DeleteController {
    private final FurnitureDao furnitureDao;

    public DeleteController(@Qualifier("furnitureJdbcDao") FurnitureDao furnitureDao) {
        this.furnitureDao = furnitureDao;
    }

    @GetMapping
    public String getForm(Model model) {
        model.addAttribute("idForm", new IdForm());
        return "delete";
    }

    @PostMapping
    public String addByForm(@Valid IdForm idForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "delete";
        }
        var id = idForm.getId();
        furnitureDao.removeById(id);
        return "redirect:/view?id=" + id;
    }
}
