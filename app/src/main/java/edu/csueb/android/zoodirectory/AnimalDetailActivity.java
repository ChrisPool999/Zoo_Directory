package edu.csueb.android.zoodirectory;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class AnimalDetailActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        TextView nameTextView = findViewById(R.id.animalNameTextView);
        TextView descriptionTextView = findViewById(R.id.animalDescriptionTextView);
        ImageView imageView = findViewById(R.id.animalImageView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("animal_name");
        String description = intent.getStringExtra("animal_description");
        int imageResId = intent.getIntExtra("animal_image", R.drawable.placeholder_image);

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        imageView.setImageResource(imageResId);
    }
}
