package com.example.quizter.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizter.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignupActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    EditText re_password;
    Button btn_signUp;
    TextView login_text_btn;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
//        ============================================
        auth = FirebaseAuth.getInstance();
        btn_signUp = findViewById(R.id.btnSignUp);
        email = findViewById(R.id.etEmailAddress);
        password = findViewById(R.id.etPassword);
        re_password = findViewById(R.id.etConfirmPassword);
        login_text_btn = findViewById(R.id.btnLogin);

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser();
            }
        });

        login_text_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, com.example.quizter.activities.LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void signUpUser() {

        String email_val = email.getText().toString().trim();
        String password_val = password.getText().toString().trim();
        String rePassword_val = re_password.getText().toString().trim();
        Log.i("TAG", "signUpUser: "+password_val);
        Log.i("TAG", "signUpUser: "+rePassword_val);
        if(email_val.isEmpty() || password_val.isEmpty() || rePassword_val.isEmpty()){
            Toast.makeText(SignupActivity.this,"Email and Password fields cannot be left empty",Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password_val.equals(rePassword_val)) {
            Toast.makeText(SignupActivity.this, "Passwords do NOT match", Toast.LENGTH_LONG).show();
            return;
        } else {
            auth.createUserWithEmailAndPassword(email_val, password_val).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(SignupActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(SignupActivity.this, "Error Creating user", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}