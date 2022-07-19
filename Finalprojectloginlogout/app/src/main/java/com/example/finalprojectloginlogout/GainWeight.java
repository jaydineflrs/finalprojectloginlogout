package com.example.finalprojectloginlogout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class GainWeight extends AppCompatActivity {
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gain_weight);
        back=findViewById(R.id.back);
        back.setOnClickListener(view ->{
            startActivity(new Intent(GainWeight.this, MainActivity.class));
        });
    }
}