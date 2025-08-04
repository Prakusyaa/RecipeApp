package com.example.recipeapp;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recipeapp.adapter.MealAdapter;
import com.example.recipeapp.model.Meal;
import com.example.recipeapp.model.MealResponse;
import com.example.recipeapp.network.RetrofitInstance;
import com.example.recipeapp.network.TheMealDbService;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText etSearch; Button btnSearch; RecyclerView rvMeals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSearch = findViewById(R.id.et_search);
        btnSearch = findViewById(R.id.btn_search);
        rvMeals = findViewById(R.id.rv_meals);
        rvMeals.setLayoutManager(new LinearLayoutManager(this));
        btnSearch.setOnClickListener(v -> {
            String query = etSearch.getText().toString().trim();
            if (!query.isEmpty()) searchMeals(query);
            else Toast.makeText(this, "Masukkan kata kunci", Toast.LENGTH_SHORT).show();
        });
    }

    private void searchMeals(String query) {
        TheMealDbService service = RetrofitInstance.getService();
        service.searchMealsByName(query).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getMeals() != null) {
                    List<Meal> meals = response.body().getMeals();
                    rvMeals.setAdapter(new MealAdapter(meals));
                } else {
                    Toast.makeText(MainActivity.this, "Tidak ada resep ditemukan", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}