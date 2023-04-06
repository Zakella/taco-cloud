package com.example.tacocloud.controller;


import com.example.tacocloud.model.Ingredient;
import com.example.tacocloud.model.Ingredient.Type;
import com.example.tacocloud.model.Taco;
import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.repo.IngredientRepository;
import com.example.tacocloud.repo.TacoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @Autowired
    private final IngredientRepository ingredientRepo;

    private TacoRepository tacoRepo;

    @Autowired
    public DesignTacoController(
            IngredientRepository ingredientRepo,
            TacoRepository tacoRepo) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepo = tacoRepo;
    }

    @ModelAttribute(name = "order")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "design")
    public Taco design() {
        return new Taco();
    }


    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = ingredientRepo.findAll();
//        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepo.findAll().;
//        List<Ingredient> ingredients = new ArrayList<>();
//        ingredientRepo.findAll().forEach(i -> ingredients.add(i));
//
//        Type[] types = Ingredient.Type.values();
//        for (Type type : types) {
//            model.addAttribute(type.toString().toLowerCase(),
//                    filterByType(ingredients, type));
//        }

        return "design";
    }

    @PostMapping
    public String processDesign(
            @Valid Taco taco, Errors errors,
            @ModelAttribute TacoOrder order) {

        if (errors.hasErrors()) {
            return "design";
        }

        Taco saved = tacoRepo.save(taco);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }

//end::injectingDesignRepository[]

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
