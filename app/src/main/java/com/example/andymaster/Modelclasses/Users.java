package com.example.andymaster.Modelclasses;

import android.os.Parcel;
import android.os.Parcelable;

public class Users {

    private String name ,token;
    private String email;
    private String username;
    private String bio;
    private String imageurl;
    private String id;
    private Boolean online;
    private long lastSeen;



    public Users(String name, String email, String username, String bio, String imageurl, String id, Boolean online, long lastSeen) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.bio = bio;
        this.imageurl = imageurl;
        this.id = id;
        this.online = online;
        this.lastSeen = lastSeen;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    protected Users(Parcel in) {
        this.id = in.readString();
        this.username = in.readString();
        this.email = in.readString();
        this.imageurl = in.readString();
        this.bio = in.readString();
        this.online = in.readInt() == 1;
        this.lastSeen = in.readLong();
    }


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.username);
        parcel.writeString(this.email);
        parcel.writeString(this.imageurl);
        parcel.writeString(this.bio);
        parcel.writeInt(this.online ? 1 : 0);
        parcel.writeLong(this.lastSeen);
    }

    public static final Parcelable.Creator<Users> CREATOR = new Parcelable.Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };
    public Users() {
    }

    public Users(String name, String email, String username, String bio, String imageurl, String id) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.bio = bio;
        this.imageurl = imageurl;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Boolean isOnline() {
        return online;
    }


    public long getLastSeen() {
        return lastSeen;
    }

}
