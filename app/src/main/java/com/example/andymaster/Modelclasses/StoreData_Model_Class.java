package com.example.andymaster.Modelclasses;

public class StoreData_Model_Class {
    private String userName;
    private String full_name;
    private String profile_pic;
    private String Id;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public StoreData_Model_Class(String userName, String full_name, String profile_pic , String Id) {
        this.userName = userName;
        this.full_name = full_name;
        this.profile_pic = profile_pic;
        this.Id = Id;
    }
}






