package com.example.myapplication_fitify;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    String firstname, gender, email, userame, password;
    public User() {

    }

    public User(String firstname, String gender, String email, String userame, String password) {
        this.firstname = firstname;
        this.gender = gender;
        this.email = email;
        this.userame = userame;
        this.password = password;


    }

    protected User(Parcel in) {
        firstname = in.readString();
        gender = in.readString();
        email = in.readString();
        userame = in.readString();
        password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstname);
        dest.writeString(gender);
        dest.writeString(email);
        dest.writeString(userame);
        dest.writeString(password);
    }
}
