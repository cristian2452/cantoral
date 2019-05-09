package com.example.chon.cantoral;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mListView = findViewById(R.id.recipe_list_view);

        final ArrayList<Recipe> recipeList = Recipe.getRecipesFromFile("recipes.json", this);

        RecipeAdapter adapter = new RecipeAdapter(this, recipeList);
        mListView.setAdapter(adapter);

        final Context context = this;
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 1
                Recipe selectedRecipe = recipeList.get(position);
                // 2
                Intent detailIntent = new Intent(context, RecipeDetailActivity.class);
                // 3
                detailIntent.putExtra("title", selectedRecipe.title);
                detailIntent.putExtra("description", selectedRecipe.description);
                detailIntent.putExtra("imageUrl", selectedRecipe.imageUrl);
                detailIntent.putExtra("url", selectedRecipe.instructionUrl);
                // 4
                startActivity(detailIntent);
            }
        });
    }
}