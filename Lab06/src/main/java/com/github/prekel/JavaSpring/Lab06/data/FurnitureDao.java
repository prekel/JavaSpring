package com.github.prekel.JavaSpring.Lab06.data;

import com.github.prekel.JavaSpring.Lab06.entity.Furniture;

import java.util.List;
import java.util.Optional;

public interface FurnitureDao {
    List<Furniture> findAll();

    List<Furniture> findByType(String type);

    Optional<Furniture> findById(int id);

    void updateById(int id, Furniture furniture);

    int insert(Furniture furniture);

    void removeById(int id);

    long count();
}
