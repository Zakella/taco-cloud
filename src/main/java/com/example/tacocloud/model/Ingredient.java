package com.example.tacocloud.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;



@Entity
@Table(name = "ingredient")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ingredient {
    @Id
    private Long id;
    private  String name;
    private  Type type;
    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}