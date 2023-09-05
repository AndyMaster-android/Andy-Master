package com.example.andymaster.Modelclasses;

import java.util.Map;

public class Hashtag {
    private String content;
    private Map<String, Boolean> hashtags;

    public Hashtag() {
        // Default constructor required for Firebase
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Boolean> getHashtags() {
        return hashtags;
    }

    public void setHashtags(Map<String, Boolean> hashtags) {
        this.hashtags = hashtags;
    }

    public Hashtag(String content, Map<String, Boolean> hashtags) {
        this.content = content;
        this.hashtags = hashtags;
    }
}
