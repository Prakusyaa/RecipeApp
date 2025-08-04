package com.example.recipeapp.adapter;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.recipeapp.DetailActivity;
import com.example.recipeapp.R;
import com.example.recipeapp.model.Meal;
import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {
    private List<Meal> meals;
    public MealAdapter(List<Meal> meals) { this.meals = meals; }

    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meal, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MealViewHolder holder, int position) {
        Meal meal = meals.get(position);
        holder.tvName.setText(meal.getStrMeal());
        Glide.with(holder.itemView.getContext())
                .load(meal.getStrMealThumb())
                .into(holder.imgThumb);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetailActivity.class);
            intent.putExtra("mealName", meal.getStrMeal());
            intent.putExtra("mealThumb", meal.getStrMealThumb());
            intent.putExtra("mealCategory", meal.getStrCategory());
            intent.putExtra("mealArea", meal.getStrArea());
            intent.putExtra("mealInstructions", meal.getStrInstructions());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() { return meals.size(); }

    static class MealViewHolder extends RecyclerView.ViewHolder {
        ImageView imgThumb; TextView tvName;
        MealViewHolder(View itemView) {
            super(itemView);
            imgThumb = itemView.findViewById(R.id.img_thumb);
            tvName = itemView.findViewById(R.id.tv_meal_name);
        }
    }
}