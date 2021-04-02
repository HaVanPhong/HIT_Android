package com.example.note;


import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Date;

public class itemNote implements Parcelable {
   private String time;
   private String date;
   private String title;
   private String content;

    public itemNote(String time,String date, String title, String content) {
        this.time = time;
        this.date=date;
        this.title = title;
        this.content = content;
    }

    public itemNote() {
    }

    protected itemNote(Parcel in) {
        time = in.readString();
        date = in.readString();
        title = in.readString();
        content = in.readString();
    }

    public static final Creator<itemNote> CREATOR = new Creator<itemNote>() {
        @Override
        public itemNote createFromParcel(Parcel in) {
            return new itemNote(in);
        }

        @Override
        public itemNote[] newArray(int size) {
            return new itemNote[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(time);
        dest.writeString(date);
        dest.writeString(title);
        dest.writeString(content);
    }
}
