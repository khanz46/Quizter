package com.example.quizter.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quizter.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginIntro extends AppCompatActivity {
    Button getStarted;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_intro);
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null){
            // User Exists
            startActivity(new Intent(LoginIntro.this, MainActivity.class));
            // if logged in, no need to back
            finish();
        }

        getStarted = findViewById(R.id.btnGetStarted);
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginIntro.this, LoginActivity.class));
            }
        });
    }
}