package com.example.recipeapp.model;
public class Meal {
    private String idMeal, strMeal, strCategory, strArea, strInstructions, strMealThumb;
    private String strIngredient1, strMeasure1; // tambahkan ingredient2-20 jika perlu

    public String getIdMeal() { return idMeal; }
    public String getStrMeal() { return strMeal; }
    public String getStrCategory() { return strCategory; }
    public String getStrArea() { return strArea; }
    public String getStrInstructions() { return strInstructions; }
    public String getStrMealThumb() { return strMealThumb; }
    public String getStrIngredient1() { return strIngredient1; }
    public String getStrMeasure1() { return strMeasure1; }
}