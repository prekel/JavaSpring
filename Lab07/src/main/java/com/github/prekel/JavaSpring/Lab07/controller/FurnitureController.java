package com.github.prekel.JavaSpring.Lab07.controller;

import com.github.prekel.JavaSpring.Lab07.data.FurnitureDao;
import com.github.prekel.JavaSpring.Lab07.entity.Furniture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/furniture")
public class FurnitureController {
    private static final Logger LOG = LoggerFactory.getLogger(FurnitureController.class);
    private final FurnitureDao furnitureDao;

    public FurnitureController(@Qualifier("furnitureRepository") FurnitureDao furnitureDao) {
        this.furnitureDao = furnitureDao;
    }

    @GetMapping(value = "/{id}", headers = {"Accept=application/json"})
    @ResponseBody
    public Furniture getFurniture(@PathVariable int id) {
        return furnitureDao.findById(id).get();
    }

    @PutMapping(value = "/{id}", headers = {"Accept=application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putFurniture(@PathVariable("id") long id, @Valid Furniture furniture) {
        furnitureDao.insert(furniture);
    }

    @DeleteMapping(value = "/{id}", headers = {"Accept=application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFurniture(@PathVariable("id") int id) {
        furnitureDao.removeById(id);
    }

    @PostMapping(headers = {"Accept=application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Furniture createFurniture(@Valid Furniture furniture, BindingResult result, HttpServletResponse response) throws BindException {
        if (result.hasErrors()) {
            throw new BindException(result);
        }
        furnitureDao.insert(furniture);
        response.setHeader("Location", "/furniture/" + furniture.getId());
        return furniture;
    }
}
