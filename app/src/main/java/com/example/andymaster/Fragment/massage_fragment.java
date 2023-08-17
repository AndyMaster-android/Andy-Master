package com.example.andymaster.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.andymaster.Fragment.Chat_Section.Chat_Handler;
import com.example.andymaster.R;

public class massage_fragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public massage_fragment() {
        // Required empty public constructor
    }
Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.massage_frament, container, false);
         btn = view.findViewById(R.id.chat);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext() , Chat_Handler.class));
            }
        });
        return view;

    }

    public void next(View view) {
        startActivity(new Intent(getContext() ,Chat_Handler.class));
    }
}