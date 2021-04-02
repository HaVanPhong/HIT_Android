package com.example.note;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLHelper extends SQLiteOpenHelper {
    static final String DB_NAME="NOTE_MANAGEMENT";
    static final int VERSON=1;
    static final String DB_TABLE_NOTE="DIARY";

    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;
    
    public SQLHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSON);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE "+DB_TABLE_NOTE
                +"(ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                +"TITLE TEXT, CONTENT TEXT, TIME TEXT, DATE TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion!=newVersion){
            onCreate(db);
        }
    }
    public void insert(itemNote itemNote){
        sqLiteDatabase=getWritableDatabase();
        contentValues=new ContentValues();
        contentValues.put("TITLE", itemNote.getTitle());
        contentValues.put("CONTENT", itemNote.getContent());
        contentValues.put("TIME", itemNote.getTime());

        contentValues.put("DATE", itemNote.getDate());
        sqLiteDatabase.insert(DB_TABLE_NOTE,null ,contentValues);
    }
    public List<itemNote> getAllDiary(){
        List<itemNote> list=new ArrayList<>();
        sqLiteDatabase=getReadableDatabase();
        Cursor cursor= sqLiteDatabase.query(DB_TABLE_NOTE, null, null, null, null, null, null);
        while (cursor.moveToNext()){
            String title=cursor.getString(cursor.getColumnIndex("TITLE"));
            String content=cursor.getString(cursor.getColumnIndex("CONTENT"));
            String time=cursor.getString(cursor.getColumnIndex("TIME"));
            String date=cursor.getString(cursor.getColumnIndex("DATE"));
            list.add(new itemNote(time, date, title, content));
        }
        return list;
    }
    public void deleteAllAccount(){
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(DB_TABLE_NOTE,null,null);
    }

}
