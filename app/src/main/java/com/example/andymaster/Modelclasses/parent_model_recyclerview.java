package com.example.andymaster.Modelclasses;

import java.util.List;

public class parent_model_recyclerview {

    // Declaration of the variables
    private String ParentItemTitle;
    private List<child_model_recyclerview> ChildItemList;

    // Constructor of the class
    // to initialize the variables
    public parent_model_recyclerview(
            String ParentItemTitle,
            List<child_model_recyclerview> ChildItemList)
    {

        this.ParentItemTitle = ParentItemTitle;
        this.ChildItemList = ChildItemList;
    }

    // Getter and Setter methods
    // for each parameter
    public String getParentItemTitle()
    {
        return ParentItemTitle;
    }

    public void setParentItemTitle(
            String parentItemTitle)
    {
        ParentItemTitle = parentItemTitle;
    }

    public List<child_model_recyclerview> getChildItemList()
    {
        return ChildItemList;
    }

    public void setChildItemList(
            List<child_model_recyclerview> childItemList)
    {
        ChildItemList = childItemList;
    }
}
