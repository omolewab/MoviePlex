package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        getSupportActionBar().hide();
        ImageView buy_tickets_button = findViewById(R.id.buy_tickets_button);
        buy_tickets_button.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, MovieListActivity.class);
            startActivity(intent);
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                return true;

            case R.id.account:
                startActivity(new Intent(this, LoginActivity.class));
                return true;

            case R.id.movies_list:
                startActivity(new Intent(this, MovieListActivity.class));
                return true;

            case R.id.contact_us:
                startActivity(new Intent(this, ContactUsActivity.class));
                return true;
        }
        return false;
    }
}