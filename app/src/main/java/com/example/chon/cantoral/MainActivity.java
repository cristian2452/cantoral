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

        ListView mListView = findViewById(R.id.songs_list_view);

        final ArrayList<Songs> recipeList = Songs.getRecipesFromFile("cantoral.json", this);

        SongsAdapter adapter = new SongsAdapter(this, recipeList);
        mListView.setAdapter(adapter);

        final Context context = this;
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 1
                Songs selectedRecipe = recipeList.get(position);
                // 2
                Intent detailIntent = new Intent(context, SongsDetailActivity.class);
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