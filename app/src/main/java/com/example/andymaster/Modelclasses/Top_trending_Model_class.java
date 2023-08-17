package com.example.andymaster.Modelclasses;

public class Top_trending_Model_class {
    int img;
    String title;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Top_trending_Model_class(int img, String title) {
        this.img = img;
        this.title = title;
    }
}
