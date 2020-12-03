package com.github.prekel.JavaSpring.Lab06.data;

import com.github.prekel.JavaSpring.Lab06.entity.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

public class FurnitureJdbcDao implements FurnitureDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Furniture> findAll() {
        return jdbcTemplate.query("SELECT * FROM Furniture", new BeanPropertyRowMapper<>(Furniture.class));
    }

    @Override
    public List<Furniture> findByType(String type) {
        return jdbcTemplate.query("SELECT * FROM Furniture WHERE type = ?", new Object[]{type}, new BeanPropertyRowMapper<>(Furniture.class));
    }

    @Override
    public Optional<Furniture> findById(int id) {
        var ret = jdbcTemplate.query("SELECT * FROM Furniture WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Furniture.class));
        return ret.stream().findFirst();
    }

    @Override
    public void updateById(int id, Furniture furniture) {
        jdbcTemplate.update("UPDATE Furniture SET type = ?, model = ?, manufacturer = ?, cost = ?, height = ? WHERE id = ?",
                furniture.getType(), furniture.getModel(), furniture.getManufacturer(), furniture.getCost(), furniture.getHeight(), id);
    }

    @Override
    public int insert(Furniture furniture) {
        return jdbcTemplate.queryForObject("INSERT INTO Furniture (id, type, model, manufacturer, cost, height) VALUES (DEFAULT,?,?,?,?,?) RETURNING id",
                new Object[]{furniture.getType(), furniture.getModel(), furniture.getManufacturer(), furniture.getCost(), furniture.getHeight()},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.NUMERIC, Types.DOUBLE}, Integer.class);
    }

    @Override
    public void removeById(int id) {
        jdbcTemplate.update("DELETE FROM Furniture WHERE id = ?", id);
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM Furniture", Long.class);
    }
}
