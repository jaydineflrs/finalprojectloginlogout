package com.example.finalprojectloginlogout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class day3 extends AppCompatActivity {
    Button back,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3);
        back=findViewById(R.id.back);
        next=findViewById(R.id.next);
        back.setOnClickListener(view ->{
            startActivity(new Intent(day3.this, MainActivity.class));
        });
        next.setOnClickListener(view ->{
            startActivity(new Intent(day3.this, day4.class));
        });
    }
}