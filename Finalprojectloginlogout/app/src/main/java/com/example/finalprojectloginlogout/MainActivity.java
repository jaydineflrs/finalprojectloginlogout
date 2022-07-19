package com.example.finalprojectloginlogout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout btnloseweight, btnstayhealthy, btngainweight;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btngainweight=findViewById(R.id.btngainweight);
        btnstayhealthy=findViewById(R.id.btnstayhealthy);
        btnloseweight=findViewById(R.id.btnloseweight);
        logout=findViewById(R.id.logout);


        btnloseweight.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this, LoseWeight.class));
        });
        btnstayhealthy.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this, StayHealthy.class));
        });
        btngainweight.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this, GainWeight.class));
        });
        logout.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });
    }
}