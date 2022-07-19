package com.example.finalprojectloginlogout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class day2 extends AppCompatActivity {
    Button back,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2);
        back=findViewById(R.id.back);
        next=findViewById(R.id.next);
        back.setOnClickListener(view ->{
            startActivity(new Intent(day2.this, MainActivity.class));
        });
        next.setOnClickListener(view ->{
            startActivity(new Intent(day2.this, day3.class));
        });
    }
}