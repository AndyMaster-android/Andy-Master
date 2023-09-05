package com.example.andymaster.Fragment.CumunitySection.Status.Model;

public class Viewed {

    private String uid;
    private long timestamp;

    public Viewed(String uid, long timestamp) {
        this.uid = uid;
        this.timestamp = timestamp;
    }

    public Viewed() {
    }

    public String getUid() {
        return uid;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
