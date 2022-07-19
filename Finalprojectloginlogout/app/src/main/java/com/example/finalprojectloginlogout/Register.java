package com.example.finalprojectloginlogout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    TextInputEditText btnremail;
    TextInputEditText btnrpassword;
    TextView login;
    Button btnregister;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnremail = findViewById(R.id.btnremail);
        btnrpassword = findViewById(R.id.btnrpassword);
        login = findViewById(R.id.login);
        btnregister = findViewById(R.id.btnregister);

        mAuth = FirebaseAuth.getInstance();

        btnregister.setOnClickListener(view ->{
            createUser();
        });

        login.setOnClickListener(view ->{
            startActivity(new Intent(Register.this, LoginActivity.class));
        });
    }

    private void createUser(){
        String email = btnremail.getText().toString();
        String password = btnrpassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            btnremail.setError("Email cannot be empty");
            btnremail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            btnrpassword.setError("Password cannot be empty");
            btnrpassword.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, LoginActivity.class));
                    }else{
                        Toast.makeText(Register.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}