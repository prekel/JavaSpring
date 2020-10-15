package com.github.prekel.JavaSpring.Lab04.component;

import com.github.prekel.JavaSpring.Lab04.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("furnitureRepository")
public interface FurnitureRepository extends JpaRepository<Furniture, Integer> {
    List<Furniture> findByType(String type);

    @Query("select s from Furniture s")
    List<Furniture> findCustomAll();

    @Transactional
    void removeById(int id);
}
