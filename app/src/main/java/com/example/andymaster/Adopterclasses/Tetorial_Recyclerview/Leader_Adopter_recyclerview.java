package com.example.andymaster.Adopterclasses.Tetorial_Recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.andymaster.Fragment.Profile;
import com.example.andymaster.Modelclasses.StoreData_Model_Class;
import com.example.andymaster.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Leader_Adopter_recyclerview extends RecyclerView.Adapter<Leader_Adopter_recyclerview.MyViewHolder> {

    FirebaseUser firebaseUser;
    private List<StoreData_Model_Class> leaderboardItems;

    Context context;
    public Leader_Adopter_recyclerview(Context context ,List<StoreData_Model_Class> leaderboardItems) {
        this.leaderboardItems = leaderboardItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comunity_searchview_recyclerview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
         final StoreData_Model_Class user = leaderboardItems.get(position);

        holder.follow.setVisibility(View.VISIBLE);

        holder.userName.setText(user.getUserName());
        holder.Disc.setText(String.valueOf(user.getFull_name()));

        isFollowing(user.getId() , holder.follow );
        Glide.with(context).load(user.getProfile_pic()).into(holder.profile_image);

        if (user.getId().equals(firebaseUser.getUid())){
            holder.follow.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.contentView ,
                        new Profile()).commit();
            }
        });
        holder.follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.follow.getText().toString().equals("Follow")){
                    FirebaseDatabase.getInstance().getReference()
                            .child("Follow").child(firebaseUser.getUid())
                            .child("Following").child(user.getId()).setValue(true);

                    FirebaseDatabase.getInstance().getReference().child("Follow").child(user.getId())
                            .child("Follower").child(firebaseUser.getUid()).setValue(true);
                }
                else {
                    FirebaseDatabase.getInstance().getReference()
                            .child("Follow").child(firebaseUser.getUid())
                            .child("Following").child(user.getId()).removeValue();

                    FirebaseDatabase.getInstance().getReference().child("Follow").child(user.getId())
                            .child("Follower").child(firebaseUser.getUid()).removeValue();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return leaderboardItems.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView Disc;
        CircleImageView profile_image;
        AppCompatButton follow;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.username);
            Disc = itemView.findViewById(R.id.full_name);
            profile_image = itemView.findViewById(R.id.profile_image);
            follow = itemView.findViewById(R.id.follow);
        }
    }
    private void  isFollowing(String user_id , AppCompatButton button){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference()
                .child("Follow").child(firebaseUser.getUid()).child("Following");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.child(user_id).exists()){
                    button.setText("Following");
                }
                else {
                    button.setText("Follow");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
