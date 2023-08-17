package com.example.andymaster.Android_Tetorials;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andymaster.Adopterclasses.Tetorial_Recyclerview.Android_tet_parent_recyclerview_adopter;
import com.example.andymaster.Modelclasses.child_model_recyclerview;
import com.example.andymaster.Modelclasses.parent_model_recyclerview;
import com.example.andymaster.R;

import java.util.ArrayList;

public class Android_Tutorial extends Fragment {

    Android_tet_parent_recyclerview_adopter parentItemAdapter ;

  private   RecyclerView Android_Course ;

  ArrayList<parent_model_recyclerview>parent_model_recyclerviews;
  ArrayList<child_model_recyclerview>child_model_recyclerviews;
  ArrayList<child_model_recyclerview>child_model_recyclerviews1;
  ArrayList<child_model_recyclerview>child_model_recyclerviews2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

              View view =  inflater.inflate(R.layout.fragment_android_tutorial, container, false);
        Android_Course = view.findViewById(R.id.Android_RecyclerView);

        Android_Course.setLayoutManager(new LinearLayoutManager(getContext()));

        child_model_recyclerviews = new ArrayList<>();
        child_model_recyclerviews.add(new child_model_recyclerview("Button" , R.drawable.icon_btn));
        child_model_recyclerviews.add(new child_model_recyclerview("TextView" , R.drawable.icon_text));
        child_model_recyclerviews.add(new child_model_recyclerview("EditText" , R.drawable.icon_edit_text));
        child_model_recyclerviews.add(new child_model_recyclerview("CheckBox" , R.drawable.icon_checkbox));
        child_model_recyclerviews.add(new child_model_recyclerview("Switch" , R.drawable.icon_switch));
        child_model_recyclerviews.add(new child_model_recyclerview("ToggleButton" , R.drawable.icon_toggle));
        child_model_recyclerviews.add(new child_model_recyclerview("RadioButton" , R.drawable.icon_radio));
        child_model_recyclerviews.add(new child_model_recyclerview("RatingBar" , R.drawable.icon_rating));
        child_model_recyclerviews.add(new child_model_recyclerview("SeekBar" , R.drawable.icon_seekbar));
        child_model_recyclerviews.add(new child_model_recyclerview("ProgressBar" , R.drawable.icon_progressbar));
        child_model_recyclerviews.add(new child_model_recyclerview("Spinner" , R.drawable.icon_spinner));
        child_model_recyclerviews.add(new child_model_recyclerview("WebView" , R.drawable.icon_web_view));
        child_model_recyclerviews.add(new child_model_recyclerview("TimePicker" , R.drawable.icone_timepicker));
        child_model_recyclerviews.add(new child_model_recyclerview("DataPicker" , R.drawable.icon_datepicker));
        child_model_recyclerviews.add(new child_model_recyclerview("Alert Dialog" , R.drawable.icon_alertdialog));


        child_model_recyclerviews1 = new ArrayList<>();
        child_model_recyclerviews1.add(new child_model_recyclerview("Buttn" , R.drawable.application));
        child_model_recyclerviews1.add(new child_model_recyclerview("Btn" , R.drawable.application));
        child_model_recyclerviews1.add(new child_model_recyclerview("Butto" , R.drawable.application));
        child_model_recyclerviews1.add(new child_model_recyclerview("Buttn" , R.drawable.application));
        child_model_recyclerviews1.add(new child_model_recyclerview("Buttn" , R.drawable.daco_5526449));



        parent_model_recyclerviews = new ArrayList<>();
        parent_model_recyclerviews.add(new parent_model_recyclerview("Simple Android UI Widgets " , child_model_recyclerviews));
        parent_model_recyclerviews.add(new parent_model_recyclerview("Complex Android UI Widgets " , child_model_recyclerviews1));

        parentItemAdapter = new Android_tet_parent_recyclerview_adopter(parent_model_recyclerviews , getContext());
        Android_Course.setLayoutManager(new LinearLayoutManager(getContext()  ));
        Android_Course.setHasFixedSize(true);
        Android_Course.setAdapter(parentItemAdapter);

        return view;
    }


}