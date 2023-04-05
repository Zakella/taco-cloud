package com.example.tacocloud.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Taco {

    private Long id;
    private Date createdAt = new Date();


    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;


    private List<Ingredient> ingredients;

}
