package com.example.andymaster.Adopterclasses.Tetorial_Recyclerview;

import static android.media.CamcorderProfile.get;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andymaster.Modelclasses.child_model_recyclerview;
import com.example.andymaster.Modelclasses.parent_model_recyclerview;
import com.example.andymaster.R;

import java.util.List;

public class Android_tet_parent_recyclerview_adopter extends RecyclerView.Adapter<Android_tet_parent_recyclerview_adopter.MyHoder> {

    private List<parent_model_recyclerview> itemList;

    private Context context;

    public Android_tet_parent_recyclerview_adopter(List<parent_model_recyclerview> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public Android_tet_parent_recyclerview_adopter.MyHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_design_tetorials , parent ,false);
        return new MyHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Android_tet_parent_recyclerview_adopter.MyHoder holder, int position) {

        // Create an instance of the ParentItem
        // class for the given position
        parent_model_recyclerview parentItem = itemList.get(position);
        MyHoder.ParentItemTitle.setText(parentItem.getParentItemTitle());

        Android_tet_child_recyclerview_Adopter child_recyclerview_adopter = new
                Android_tet_child_recyclerview_Adopter(itemList.get(position).getChildItemList(),context);
        MyHoder.ChildRecyclerView.setLayoutManager(new LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL ,false));
       holder.ChildRecyclerView.setAdapter(child_recyclerview_adopter);


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyHoder extends RecyclerView.ViewHolder {
         static TextView ParentItemTitle;
         static RecyclerView ChildRecyclerView;
        public MyHoder(@NonNull View itemView) {
            super(itemView);
            ParentItemTitle = itemView.findViewById(R.id.parent_item_title);
            ChildRecyclerView = itemView.findViewById(R.id.child_recyclerview);


        }
    }
}
