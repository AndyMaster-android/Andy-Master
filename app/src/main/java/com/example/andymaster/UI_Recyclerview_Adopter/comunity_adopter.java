package com.example.andymaster.UI_Recyclerview_Adopter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.andymaster.Modelclasses.Post_Model_class;
import com.example.andymaster.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class comunity_adopter extends RecyclerView.Adapter<comunity_adopter.Myview> {

    public Context context;
    public List<Post_Model_class> mpost;

    private FirebaseUser firebaseUser;

    public comunity_adopter(Context context, List<Post_Model_class> mpost) {
        this.context = context;
        this.mpost = mpost;
    }

    @NonNull
    @Override
    public comunity_adopter.Myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comunity_adopter_itme, parent , false);

        return new  Myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull comunity_adopter.Myview holder, int position) {

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        Post_Model_class postModelClass = mpost.get(position);
        Glide.with(context).load(postModelClass.getPostImage()).into(holder.post_img);
        if (postModelClass.getPost_Disc().equals("")){
            holder.Disc.setVisibility(View.GONE);
        }
        else {
            holder.Disc.setVisibility(View.VISIBLE);
            holder.Disc.setText(postModelClass.getPost_Disc());
        }

    }

    @Override
    public int getItemCount() {
        return mpost.size();
    }

    public class Myview extends RecyclerView.ViewHolder {

        public ImageView profile_img , post_img,like ,save , comment;
        public TextView username , likes , title , Disc , comments;
        public Myview(@NonNull View itemView) {
            super(itemView);
            profile_img =itemView.findViewById(R.id.image_profile);
            post_img =itemView.findViewById(R.id.post_image);
            like =itemView.findViewById(R.id.likes_post);
            save =itemView.findViewById(R.id.comments_post);
            comment =itemView.findViewById(R.id.save_post);

            username =itemView.findViewById(R.id.User_name);
            likes =itemView.findViewById(R.id.likes);
            Disc =itemView.findViewById(R.id.Disc);
            comments =itemView.findViewById(R.id.coments);



        }
    }
    private  void publisherinfo(ImageView image_profile, TextView username, String userId){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users :").child(userId);



    }
}
