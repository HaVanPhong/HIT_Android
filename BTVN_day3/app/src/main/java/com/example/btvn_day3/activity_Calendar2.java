package com.example.btvn_day3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_Calendar2 extends AppCompatActivity {
    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__calendar2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        btnBack = findViewById(R.id.btnBack);
//        android.app.ActionBar actionBar1 =getActionBar();
//        actionBar1.setDisplayHomeAsUpEnabled(true);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_Calendar2.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}