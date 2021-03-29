package com.recipebook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int recipeId;

    private String recipeName;
    private String imageUrl;
    private String description;
    private List<String> ingredients;
}
