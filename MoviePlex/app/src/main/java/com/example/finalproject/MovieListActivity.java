package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    private RecyclerView recyclerView;
    private ArrayList<DataModel> recyclerDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("All Movies");

        recyclerView=findViewById(R.id.movie_list_recycler_view);

        // created new array list..
        recyclerDataArrayList=new ArrayList<>();

        // added data to array list
        recyclerDataArrayList.add(new DataModel("Avengers", R.drawable.avengers));
        recyclerDataArrayList.add(new DataModel("Captain Marvel", R.drawable.captain_marvel));
        recyclerDataArrayList.add(new DataModel("Iron Man", R.drawable.iron_man));
        recyclerDataArrayList.add(new DataModel("Black Widow", R.drawable.black_widow));
        recyclerDataArrayList.add(new DataModel("Spider Man", R.drawable.spiderman));
        recyclerDataArrayList.add(new DataModel("Thor", R.drawable.thor));

        // added data from arraylist to adapter class.
        MovieListRecyclerAdapter adapter=new MovieListRecyclerAdapter(recyclerDataArrayList,this);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.movies_list);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                startActivity(new Intent(this, HomeActivity.class));
                return true;

            case R.id.account:
                startActivity(new Intent(this, LoginActivity.class));
                return true;

            case R.id.movies_list:
                return true;

            case R.id.contact_us:
                startActivity(new Intent(this, ContactUsActivity.class));
                return true;
        }
        return false;
    }
}