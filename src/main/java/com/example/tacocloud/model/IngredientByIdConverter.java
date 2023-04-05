package com.example.tacocloud.model;

import java.util.HashMap;
import java.util.Map;
import com.example.tacocloud.model.Ingredient.Type;
import com.example.tacocloud.repo.IngredientRepository;
import com.example.tacocloud.repo.JdbcIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepo;
    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findById(id)
                .orElse(null);
    }
}
