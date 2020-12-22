package com.github.prekel.JavaSpring.Lab08.controller;

import com.github.prekel.JavaSpring.Lab08.data.FurnitureDao;
import com.github.prekel.JavaSpring.Lab08.entity.Furniture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/furniture")
public class FurnitureController {
    private static final Logger LOG = LoggerFactory.getLogger(FurnitureController.class);
    private final FurnitureDao furnitureDao;
    @Autowired
    JmsTemplate jmsTemplate;

    public FurnitureController(@Qualifier("furnitureRepository") FurnitureDao furnitureDao) {
        this.furnitureDao = furnitureDao;
    }

    @GetMapping
    @ResponseBody
    public Collection<Furniture> getFurnitures() {
        jmsTemplate.convertAndSend("get all");
        return furnitureDao.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Furniture> getFurniture(@PathVariable int id) {
        jmsTemplate.convertAndSend("get");
        return ResponseEntity.of(furnitureDao.findById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putFurniture(@PathVariable int id, @RequestBody Furniture furniture) {
        jmsTemplate.convertAndSend("put");
        furnitureDao.updateById(id, furniture);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFurniture(@PathVariable int id) {
        jmsTemplate.convertAndSend("delete");
        furnitureDao.removeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Furniture createFurniture(@RequestBody Furniture furniture, HttpServletResponse response) {
        jmsTemplate.convertAndSend("post");
        furnitureDao.insert(furniture);
        response.setHeader("Location", "/furniture/" + furniture.getId());
        return furniture;
    }
}
