package com.github.prekel.JavaSpring.Lab04.component;

import com.github.prekel.JavaSpring.Lab04.entity.Furniture;

import java.util.List;
import java.util.Optional;

public interface FurnitureDao {
    List<Furniture> findAll();
    List<Furniture> findByType(String type);
    Optional<Furniture> findById(int id);
    void updateById(int id, Furniture furniture);
    void insert(Furniture furniture);
    void removeById(int id);
}
