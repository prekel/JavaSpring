package com.github.prekel.JavaSpring.Lab04.component;

import com.github.prekel.JavaSpring.Lab04.entity.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component("furnitureJdbcDao")
public class FurnitureJdbcDao implements FurnitureDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Furniture> findAll() {
        return jdbcTemplate.query("select * from Furniture", new BeanPropertyRowMapper<>(Furniture.class));
    }

    @Override
    public List<Furniture> findByType(String type) {
        return jdbcTemplate.query("select * from Furniture where type = ?", new Object[]{type}, new BeanPropertyRowMapper<>(Furniture.class));
    }

    @Override
    public Optional<Furniture> findById(int id) {
        var ret = jdbcTemplate.query("select * from Furniture where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Furniture.class));
        return ret.stream().findFirst();
    }

    @Override
    public void update(Furniture furniture) {
        jdbcTemplate.update("update Furniture type = ?, model = ?, manufacturer = ?, cost = ?, height = ? where id = ?",
                furniture.getType(), furniture.getModel(), furniture.getManufacturer(), furniture.getCost(), furniture.getHeight(), furniture.getId());
    }

    @Override
    public void insert(Furniture furniture) {
        jdbcTemplate.update("insert into Furniture (id, type, model, manufacturer, cost, height) values (DEFAULT ,?,?,?,?,?)",
                furniture.getType(), furniture.getModel(), furniture.getManufacturer(), furniture.getCost(), furniture.getHeight());
    }
}
