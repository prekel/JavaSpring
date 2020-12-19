package com.github.prekel.JavaSpring.Lab07.controller;

import com.github.prekel.JavaSpring.Lab07.data.FurnitureDao;
import com.github.prekel.JavaSpring.Lab07.entity.Furniture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/furniture")
public class FurnitureController {
    private static final Logger LOG = LoggerFactory.getLogger(FurnitureController.class);
    private final FurnitureDao furnitureDao;

    public FurnitureController(@Qualifier("furnitureRepository") FurnitureDao furnitureDao) {
        this.furnitureDao = furnitureDao;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Furniture> getFurniture(@PathVariable int id) {
        return ResponseEntity.of(furnitureDao.findById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putFurniture(@PathVariable int id, @RequestBody Furniture furniture) {
        furnitureDao.updateById(id, furniture);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFurniture(@PathVariable int id) {
        furnitureDao.removeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Furniture createFurniture(@RequestBody Furniture furniture, HttpServletResponse response) {
        furnitureDao.insert(furniture);
        response.setHeader("Location", "/furniture/" + furniture.getId());
        return furniture;
    }
}
