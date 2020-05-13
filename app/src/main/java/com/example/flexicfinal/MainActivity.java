package com.example.flexicfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btnDay, btnNight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_second_fragment);

//        btnDay = findViewById(R.id.btnDay);
//        btnNight = findViewById(R.id.btnNight);
//
//        btnDay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                finish();
//            }
//        });
//
//        btnNight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                finish();
//            }
//        });

    }


}
