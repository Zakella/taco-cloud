package com.example.tacocloud.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("ingredient_ref")
@Data
public class IngredientRef {
    private final String ingredient;
}
