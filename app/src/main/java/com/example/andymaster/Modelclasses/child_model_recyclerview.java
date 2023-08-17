package com.example.andymaster.Modelclasses;

public class child_model_recyclerview {

        // Declaration of the variable
        private String ChildItemTitle;
        private int image ;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
// Constructor of the class
        // to initialize the variable*

    public child_model_recyclerview(String childItemTitle, int image) {
        ChildItemTitle = childItemTitle;
        this.image = image;
    }

    // Getter and Setter method
        // for the parameter
        public String getChildItemTitle()
        {
            return ChildItemTitle;
        }

        public void setChildItemTitle(
                String childItemTitle)
        {
            ChildItemTitle = childItemTitle;
        }
    }

