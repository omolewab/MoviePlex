package com.example.finalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {
    Button createAccount;
    Button login;
    EditText firstname;
    EditText lastname;
    EditText email;
    EditText password;
    EditText confirmedpassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firstname = findViewById(R.id.FirstName);
        lastname = findViewById(R.id.LastName);
        email = findViewById(R.id.NewEmail);
        password = findViewById(R.id.NewPassword);
        confirmedpassword = findViewById(R.id.ConfirmNewPassword);
        createAccount = findViewById(R.id.CreateAccountButton);
        login = findViewById(R.id.Loginbutton);

        DataManager dm = new DataManager(this);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dm.insert(
                        firstname.getText().toString(),
                        lastname.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString(),
                        confirmedpassword.getText().toString());
                Log.i("info",  firstname.getText().toString());
            }
        });

    }
}
