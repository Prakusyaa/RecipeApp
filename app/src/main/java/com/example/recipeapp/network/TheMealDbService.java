package com.example.recipeapp.network;
import com.example.recipeapp.model.MealResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMealDbService {
    @GET("/api/json/v1/1/search.php")
    Call<MealResponse> searchMealsByName(@Query("s") String name);
}