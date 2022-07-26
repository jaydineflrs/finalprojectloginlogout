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

public class LoginActivity extends AppCompatActivity {

    TextInputEditText btnemail;
    TextInputEditText btnpassword;
    TextView register;
    Button btnlogin;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnemail = findViewById(R.id.btnemail);
        btnpassword = findViewById(R.id.btnpassword);
        btnlogin = findViewById(R.id.btnlogin);
        register = findViewById(R.id.register);

        mAuth = FirebaseAuth.getInstance();

        btnlogin.setOnClickListener(view -> {
            loginUser();
        });
        register.setOnClickListener(view ->{
            startActivity(new Intent(LoginActivity.this, Register.class));
        });
    }

    private void loginUser(){
        String email = btnemail.getText().toString();
        String password = btnpassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            btnemail.setError("Email cannot be empty");
            btnemail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            btnpassword.setError("Password cannot be empty");
            btnpassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(LoginActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}
