package com.example.note;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tvContent, tvTitle, tvDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Dạo này Phòng hay quên quá!!!");
        actionBar.setDisplayHomeAsUpEnabled(true);
        tvContent=findViewById(R.id.tvGetContent);
        tvTitle=findViewById(R.id.tvGetTitle);
        tvDate=findViewById(R.id.tvGetDate);
        Intent intent1=getIntent();
        itemNote itemNote=intent1.getParcelableExtra("itemNote");
        tvContent.setText(itemNote.getContent()+"");
        tvDate.setText(itemNote.getDate());
        tvTitle.setText(itemNote.getTitle());

    }
}