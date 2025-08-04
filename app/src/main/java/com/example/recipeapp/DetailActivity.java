package com.example.recipeapp;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imgMeal = findViewById(R.id.img_meal_detail);
        TextView tvName = findViewById(R.id.tv_meal_name_detail);
        TextView tvCategoryArea = findViewById(R.id.tv_meal_category_area);
        TextView tvInstructions = findViewById(R.id.tv_meal_instructions);

        String name = getIntent().getStringExtra("mealName");
        String thumb = getIntent().getStringExtra("mealThumb");
        String category = getIntent().getStringExtra("mealCategory");
        String area = getIntent().getStringExtra("mealArea");
        String instructions = getIntent().getStringExtra("mealInstructions");

        tvName.setText(name);
        tvCategoryArea.setText(category + " | " + area);
        tvInstructions.setText(instructions);

        Glide.with(this).load(thumb).into(imgMeal);
    }
}