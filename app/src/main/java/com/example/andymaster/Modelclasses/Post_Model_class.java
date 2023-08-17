package com.example.andymaster.Modelclasses;

public class Post_Model_class {
    String post_Id;
    String postImage;
    String post_Disc;
    String post_Publisher;
    String post_title;

    public String getPost_Id() {
        return post_Id;
    }

    public void setPost_Id(String post_Id) {
        this.post_Id = post_Id;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getPost_Disc() {
        return post_Disc;
    }

    public void setPost_Disc(String post_Disc) {
        this.post_Disc = post_Disc;
    }

    public String getPost_Publisher() {
        return post_Publisher;
    }

    public void setPost_Publisher(String post_Publisher) {
        this.post_Publisher = post_Publisher;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public Post_Model_class() {

    }

    public Post_Model_class(String post_Id, String postImage, String post_Disc, String post_Publisher, String post_title) {
        this.post_Id = post_Id;
        this.postImage = postImage;
        this.post_Disc = post_Disc;
        this.post_Publisher = post_Publisher;
        this.post_title = post_title;
    }
}
