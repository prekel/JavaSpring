package com.github.prekel.JavaSpring.Lab04.component;

import com.github.prekel.JavaSpring.Lab04.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository("furnitureRepository")
public interface FurnitureRepository extends JpaRepository<Furniture, Integer>, FurnitureDao {
    List<Furniture> findByType(String type);

    @Transactional
    void removeById(int id);

    Optional<Furniture> findById(int id);

    default void update(Furniture furniture) {
        save(furniture);
    }

    default void insert(Furniture furniture) {
        save(furniture);
    }
}
