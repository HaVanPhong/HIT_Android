package com.example.btvn_day3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class calendar1 extends AppCompatActivity {
    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar1);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ActionBar actionBar1=getActionBar();
//                actionBar1.setDisplayHomeAsUpEnabled(true);
                Intent intent=new Intent(calendar1.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}