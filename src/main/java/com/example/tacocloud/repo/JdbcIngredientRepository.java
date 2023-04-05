package com.example.tacocloud.repo;

import com.example.tacocloud.model.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // ...
    @Override
    public List<Ingredient> findAll() {
//        return jdbcTemplate.query("Select ID, NAME, TYPE from INGREDIENT",
//                this::mapRowToIngredient
//        );

        String sql = "SELECT ID, NAME, TYPE FROM INGREDIENT";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            String id = rs.getString("ID");
            String name = rs.getString("NAME");
            Ingredient.Type type = Ingredient.Type.valueOf(rs.getString("TYPE"));
            return new Ingredient(id, name, type);
        });
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> results = jdbcTemplate.query(
                "select ID, NAME, TYPE from INGREDIENT where id=?",
                this::mapRowToIngredient,
                id);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "insert into INGREDIENT (ID, NAME, TYPE) values  (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum)
            throws SQLException {
        return new Ingredient(
                row.getString("ID"),
                row.getString("NAME"),
                Ingredient.Type.valueOf(row.getString("type")));
    }
}
