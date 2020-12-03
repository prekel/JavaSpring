package com.github.prekel.JavaSpring.Lab06.component;

import com.github.prekel.JavaSpring.Lab06.data.FurnitureDao;
import com.github.prekel.JavaSpring.Lab06.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Integer>, FurnitureDao {
    List<Furniture> findByType(String type);

    @Transactional
    void removeById(int id);

    Optional<Furniture> findById(int id);

    default void updateById(int id, Furniture furniture) {
        furniture.setId(id);
        save(furniture);
    }

    default int insert(Furniture furniture) {
        return save(furniture).getId();
    }
}
