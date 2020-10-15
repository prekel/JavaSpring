package com.github.prekel.JavaSpring.Lab04.component;

import com.github.prekel.JavaSpring.Lab04.entity.Furniture;

import java.util.List;
import java.util.Optional;

public interface FurnitureDao {
    List<Furniture> findAll();
    List<Furniture> findByType(String type);
    Optional<Furniture> findById(int id);
    void update(Furniture furniture);
    void insert(Furniture furniture);
}
