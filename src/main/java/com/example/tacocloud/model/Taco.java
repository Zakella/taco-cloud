package com.example.tacocloud.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table("taco")
public class Taco {

    @Id
    private Long id;
    private Date createdAt = new Date();

    private List<Taco> tacos = new ArrayList<>();


    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;


    private List<Ingredient> ingredients;

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

}
