package com.github.prekel.JavaSpring.Lab07.component;

import com.github.prekel.JavaSpring.Lab07.data.FurnitureDao;
import com.github.prekel.JavaSpring.Lab07.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Integer>, FurnitureDao {
    List<Furniture> findByType(String type);

    Optional<Furniture> findById(int id);

    default void updateById(int id, Furniture furniture) {
        furniture.setId(id);
        save(furniture);
    }

    default int insert(Furniture furniture) {
        return save(furniture).getId();
    }

    @Transactional
    void removeById(int id);
}
