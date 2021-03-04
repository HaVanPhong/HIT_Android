package com.example.btvn_day3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.StatusBarManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout alarm1;
    private LinearLayout alarm2;
    private LinearLayout alarm3;
    private Button btnPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        alarm1 = findViewById(R.id.alarm1);
        alarm2 = findViewById(R.id.alarm2);
        alarm3 = findViewById(R.id.alarm3);
        btnPlus=findViewById(R.id.btnPlus);
        alarm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, calendar1.class);
                startActivity(intent);
            }
        });
        alarm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_Calendar2.class);
                startActivity(intent);
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog  dialog =new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Thêm Báo Thức?")
                        .setMessage("Yes | No")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Có thêm đc đâu hehe", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Hủy", Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                dialog.show();
            }
        });


    }
}