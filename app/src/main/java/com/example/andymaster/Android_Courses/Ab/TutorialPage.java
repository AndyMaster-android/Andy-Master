package com.example.andymaster.Android_Courses.Ab;

public class TutorialPage {    private int imageResource;
    private String text;
    private int progress;

    public TutorialPage(int imageResource, String text, int progress) {
        this.imageResource = imageResource;
        this.text = text;
        this.progress = progress;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText() {
        return text;
    }

    public int getProgress() {
        return progress;
    }
}
