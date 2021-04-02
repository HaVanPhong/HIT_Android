package com.example.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton btnfab;
    RecyclerView rcvRecyclerView;
    List<itemNote> list=new ArrayList<>();
    SQLHelper sqlHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        sqlHelper=new SQLHelper(MainActivity.this);

//        sqlHelper.deleteAllAccount();
        Intent intent1=getIntent();
        itemNote itemNote= intent1.getParcelableExtra("insertItemNote");
        if(itemNote!=null) {
            sqlHelper.insert(itemNote);
        }

        list=sqlHelper.getAllDiary();
//        Toast.makeText(MainActivity.this, list.get(0).getTitle(), Toast.LENGTH_SHORT).show();

        itemNoteAdapter adapter=new itemNoteAdapter(MainActivity.this, list);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        rcvRecyclerView.setLayoutManager(layoutManager);
        rcvRecyclerView.setAdapter(adapter);
        adapter.setiOnclick(new iOnclick() {
            @Override
            public void Click(itemNote itemNote) {
                Intent intent=new Intent(MainActivity.this , MainActivity2.class);
                intent.putExtra("itemNote", (Parcelable) itemNote);
                startActivity(intent);
            }
        });
        btnfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this, Insert_diary.class);
                startActivity(intent1);
            }
        });

    }

    private void AnhXa() {
        btnfab=findViewById(R.id.btnfab);
        rcvRecyclerView=findViewById(R.id.rcv);
    }
}