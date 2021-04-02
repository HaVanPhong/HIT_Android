package com.example.note;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Insert_diary extends AppCompatActivity {
    EditText edtTitle, edtContent;
    Button btnSave;
    SQLHelper sqlHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_diary);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Hãy lưa lại âm mưu của mình nào!!!");
        AnhXa();


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=edtTitle.getText()+"";
                String content=edtContent.getText()+"";

                Calendar now =Calendar.getInstance();
                SimpleDateFormat sdf =null;
                String strDateFormat = "dd/MM/yyyy HH:mm:ss";
                sdf=new SimpleDateFormat(strDateFormat);
                String date=sdf.format(now.getTime());

                itemNote itemNote=new itemNote(null, date, title, content);
                Intent intent1=new Intent(Insert_diary.this, MainActivity.class);
                edtContent.setText("");
                edtTitle.setText("");
                intent1.putExtra("insertItemNote", itemNote);
                startActivity(intent1);
            }
        });


    }


    private void AnhXa() {
        edtTitle=findViewById(R.id.edtTitle);
        edtContent=findViewById(R.id.edtContent);
        btnSave=findViewById(R.id.btnSave);
    }
}