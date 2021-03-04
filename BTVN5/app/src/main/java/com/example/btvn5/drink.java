package com.example.btvn5;

import android.os.Parcel;
import android.os.Parcelable;

public class drink implements Parcelable {
    int avt,core,  count;
    String name;

    public drink() {
    }

    public drink(int avt, int core, int count,  String name) {
        this.avt = avt;
        this.core = core;
        this.count=count;
        this.name = name;
    }

    protected drink(Parcel in) {
        avt = in.readInt();
        core = in.readInt();
        count = in.readInt();
        name = in.readString();
    }

    public static final Creator<drink> CREATOR = new Creator<drink>() {
        @Override
        public drink createFromParcel(Parcel in) {
            return new drink(in);
        }

        @Override
        public drink[] newArray(int size) {
            return new drink[size];
        }
    };

    public int getAvt() {
        return avt;
    }

    public void setAvt(int avt) {
        this.avt = avt;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int monney) {
        this.count = monney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "drink{" +
                "avt=" + avt +
                ", core=" + core +
                ", monney=" + count +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(avt);
        dest.writeInt(core);
        dest.writeInt(count);
        dest.writeString(name);
    }
}
