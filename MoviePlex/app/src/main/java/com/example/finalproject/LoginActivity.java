package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoginActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        Button Loginbutton = (Button) findViewById(R.id.Loginbutton);
        Loginbutton.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, MovieListActivity.class);
            startActivity(intent);
        });
        Button Signupbutton = (Button) findViewById(R.id.Signupbutton);
        Signupbutton.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, DataActivity.class);
            startActivity(intent);
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.account);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                startActivity(new Intent(this, HomeActivity.class));
                return true;

            case R.id.account:
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
