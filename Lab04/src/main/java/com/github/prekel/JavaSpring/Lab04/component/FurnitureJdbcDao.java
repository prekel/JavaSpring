package com.github.prekel.JavaSpring.Lab04.component;

import com.github.prekel.JavaSpring.Lab04.entity.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component("furnitureJdbcDao")
public class FurnitureJdbcDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Furniture> findAll() {
        return jdbcTemplate.query("select * from Furniture", new BeanPropertyRowMapper<>(Furniture.class));
    }

    public int insert(Furniture furniture) {
        return jdbcTemplate.update("insert into Furniture (id, type, model, manufacturer, cost, height) values (DEFAULT ,?,?,?,?,?)",
                furniture.getType(), furniture.getModel(), furniture.getManufacturer(), furniture.getCost(), furniture.getHeight());
    }
}
