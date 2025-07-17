package edu.csueb.android.zoodirectory;

import android.view.Menu;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AnimalAdaptor adapter;
    private List<Animal> animalList;

    @Override
     public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
     }

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.animalRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal(getString(R.string.tiger), R.drawable.tiger, getString(R.string.tiger_desc)));
        animalList.add(new Animal(getString(R.string.lion), R.drawable.lion, getString(R.string.lion_desc)));
        animalList.add(new Animal(getString(R.string.elephant), R.drawable.elephant, getString(R.string.elephant_desc)));
        animalList.add(new Animal(getString(R.string.monkey), R.drawable.monkey, getString(R.string.monkey_desc)));
        animalList.add(new Animal(getString(R.string.crocodile), R.drawable.crocodile, getString(R.string.crocodile_desc)));

        adapter = new AnimalAdaptor(this, animalList);
        recyclerView.setAdapter(adapter);
     }
}
