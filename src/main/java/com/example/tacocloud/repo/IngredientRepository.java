package com.example.tacocloud.repo;

import com.example.tacocloud.model.Ingredient;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

//    @Query("Select * from Ingredient")
//    List<Ingredient> findAllTest();

}
