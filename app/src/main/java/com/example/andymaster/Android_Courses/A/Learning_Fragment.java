package com.example.andymaster.Android_Courses.A;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andymaster.Adopterclasses.Android_Coureses_Recyclerview_Adopter;
import com.example.andymaster.Modelclasses.Top_trending_Model_class;
import com.example.andymaster.R;

import java.util.ArrayList;

public class Learning_Fragment extends Fragment {

    public Learning_Fragment() {
        // Required empty public constructor
    }

    RecyclerView Android_Course ;
    ArrayList<Top_trending_Model_class> arrayList = new ArrayList<>();
    Android_Coureses_Recyclerview_Adopter adopter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_learning_, container, false);
        Android_Course = view.findViewById(R.id.Android_RecyclerView);
      recyclerview();
        // Inflate the layout for this fragment
        return view;

    }
    private void recyclerview(){
        Android_Course.setHasFixedSize(true);
        Android_Course.setLayoutManager(new GridLayoutManager(getContext() ,2));
        AndroidList();
        adopter = new Android_Coureses_Recyclerview_Adopter(getContext() , arrayList);
        Android_Course.setAdapter(adopter);
    }
    private void AndroidList() {
        arrayList.add(new Top_trending_Model_class(R.drawable.icon_bg_blue ,"Get Started"));
        arrayList.add(new Top_trending_Model_class(R.drawable.road_map ,"Road Map"));
        arrayList.add(new Top_trending_Model_class(R.drawable.android ,"Android"));
        arrayList.add(new Top_trending_Model_class(R.drawable.platform ,"Platform"));
        arrayList.add(new Top_trending_Model_class(R.drawable.android_studio_48 ,"Android Studio"));
        arrayList.add(new Top_trending_Model_class(R.drawable.mobile ,"Component "));
        arrayList.add(new Top_trending_Model_class(R.drawable.daco_5526449 ,"UI Design"));
        arrayList.add(new Top_trending_Model_class(R.drawable.app_development ,"Storage"));
        arrayList.add(new Top_trending_Model_class(R.drawable.app_development__1_ ,"Threading"));
        arrayList.add(new Top_trending_Model_class(R.drawable.application ,"Debugging"));
        arrayList.add(new Top_trending_Model_class(R.drawable.native_platform ,"Architure"));


    }
}