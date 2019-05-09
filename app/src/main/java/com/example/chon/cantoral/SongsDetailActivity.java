package com.example.chon.cantoral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SongsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        // 1
        String title = this.getIntent().getExtras().getString("title");
        String description = this.getIntent().getExtras().getString("description");
        String imageUrl = this.getIntent().getExtras().getString("imageUrl");
        String url = this.getIntent().getExtras().getString("url");
        // 2
        setTitle(title);
        // 3
        TextView mDescription = findViewById(R.id.txt_description);
        ImageView mImageUrl = findViewById(R.id.picture);


        mDescription.setText(description);

        Picasso.get()
                .load(imageUrl).placeholder(R.mipmap.ic_launcher).into(mImageUrl);
    }
}
