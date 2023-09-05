package com.example.andymaster.Adopterclasses;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andymaster.Android_Courses.Ab.intro_Android_Activity;
import com.example.andymaster.Android_Courses.Ad.Android_studio;
import com.example.andymaster.Android_Courses.Ab.Get_Start_Ac;
import com.example.andymaster.Android_Courses.Ae.Component;
import com.example.andymaster.Android_Courses.Af.Storage;
import com.example.andymaster.Modelclasses.Top_trending_Model_class;
import com.example.andymaster.Android_Courses.Ac.Platform_Android;
import com.example.andymaster.R;
import com.example.andymaster.Android_Courses.Ab.Road_Map;
import com.example.andymaster.Android_Courses.Ab.intro_Android;

import java.util.ArrayList;

public class Android_Coureses_Recyclerview_Adopter extends RecyclerView.Adapter<Android_Coureses_Recyclerview_Adopter.Myholder> {

    Context context;
    ArrayList<Top_trending_Model_class> Top_trending_data;

    public Android_Coureses_Recyclerview_Adopter(Context context, ArrayList<Top_trending_Model_class> top_trending_data) {
        this.context = context;
        Top_trending_data = top_trending_data;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_desgin, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        Top_trending_Model_class top_trending_model_class = Top_trending_data.get(position);
        holder.img.setImageResource(top_trending_model_class.getImg());
        holder.txt.setText(top_trending_model_class.getTitle());


    }

    @Override
    public int getItemCount() {
        return Top_trending_data.size();
    }

    public class Myholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img;
        TextView txt;
        CardView cardView;

        public Myholder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.RecyclerView_card);
            img = itemView.findViewById(R.id.top_rec_img);
            txt = itemView.findViewById(R.id.top_rec_text);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = this.getAdapterPosition();
            switch (position){
                case 0:
                    context.startActivity(new Intent(context , Get_Start_Ac.class));
                    break;
                case 1:
                    context.startActivity(new Intent(context , Road_Map.class));
                    break;
                case 2:
                    context.startActivity(new Intent(context, intro_Android_Activity.class));
                    break;
                case 3:
                    context.startActivity(new Intent(context, Platform_Android.class));
                    break;
                case 4:
                    context.startActivity(new Intent(context, Android_studio.class));
                    break;
                case 5:
                    context.startActivity(new Intent(context, Component.class));
                    break;
                case 7:
                    context.startActivity(new Intent(context, Storage.class));
                    break;

                default:
                    break;
            }
        }
    }
}

