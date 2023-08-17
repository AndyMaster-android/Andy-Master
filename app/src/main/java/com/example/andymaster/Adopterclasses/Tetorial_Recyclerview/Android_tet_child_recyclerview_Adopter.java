package com.example.andymaster.Adopterclasses.Tetorial_Recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andymaster.Android_Tetorials.A_AlertDialog.AlertDialog_output;
import com.example.andymaster.Android_Tetorials.A_Check_Box.Check_Box;
import com.example.andymaster.Android_Tetorials.A_DataPicker.DataPicker_output;
import com.example.andymaster.Android_Tetorials.A_EDitText.EditText;
import com.example.andymaster.Android_Tetorials.A_ProgressBar.ProgressBar_output;
import com.example.andymaster.Android_Tetorials.A_Radio_btn.Radio_btn;
import com.example.andymaster.Android_Tetorials.A_RatingBar.RatingBar;
import com.example.andymaster.Android_Tetorials.A_SeekBar.SeekBar_output;
import com.example.andymaster.Android_Tetorials.A_Spinner.Spinner_output;
import com.example.andymaster.Android_Tetorials.A_Switch.Switch_btn_output;
import com.example.andymaster.Android_Tetorials.A_TimePicker.TimePicker_output;
import com.example.andymaster.Android_Tetorials.A_btn.Button_output;
import com.example.andymaster.Android_Tetorials.A_TextView.Text_View;
import com.example.andymaster.Android_Tetorials.A_Toggale_btn.Toggle_btn;
import com.example.andymaster.Android_Tetorials.A_webView.WebView_output;
import com.example.andymaster.Modelclasses.child_model_recyclerview;
import com.example.andymaster.R;

import java.util.List;

public class Android_tet_child_recyclerview_Adopter extends RecyclerView.Adapter<Android_tet_child_recyclerview_Adopter.myHoder> {

    private List<child_model_recyclerview> ChildItemList;
    private Context context;


    public Android_tet_child_recyclerview_Adopter(List<child_model_recyclerview> childItemList, Context context) {
        ChildItemList = childItemList;
        this.context = context;
    }

    @Override
    public Android_tet_child_recyclerview_Adopter.myHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_ryclerview, null, false);
        return new myHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Android_tet_child_recyclerview_Adopter.myHoder holder, int position) {
        // Create an instance of the ChildItem
        // class for the given position
        child_model_recyclerview childItem
                = ChildItemList.get(position);
        // For the created instance, set title.
        // No need to set the image for
        // the ImageViews because we have
        // provided the source for the images
        // in the layout file itself
        holder.ChildItemTitle.setText(childItem.getChildItemTitle());
        holder.img.setImageResource(childItem.getImage());


    }

    @Override
    public int getItemCount() {
        return ChildItemList.size();
    }

    public class myHoder extends RecyclerView.ViewHolder {
        TextView ChildItemTitle;
        ImageView img;
        CardView cardView;

        public myHoder(@NonNull View itemView) {
            super(itemView);
            ChildItemTitle = itemView.findViewById(R.id.child_item_title);
            img = itemView.findViewById(R.id.img_child_item);
            cardView = itemView.findViewById(R.id.child_cv_recyclerview);
            cardView.setOnClickListener(v -> {
                int Position = getAdapterPosition();
                child_model_recyclerview childItem
                        = ChildItemList.get(getAdapterPosition());

                if (childItem.getChildItemTitle().equals("Button")) {
                    context.startActivity(new Intent(context, Button_output.class));
                }
                if (childItem.getChildItemTitle().equals("TextView")) {
                    context.startActivity(new Intent(context, Text_View.class));
                }
                if (childItem.getChildItemTitle().equals("EditText")) {
                    context.startActivity(new Intent(context, EditText.class));
                }
                if (childItem.getChildItemTitle().equals("CheckBox")) {
                    context.startActivity(new Intent(context, Check_Box.class));
                }
                if (childItem.getChildItemTitle().equals("Switch")) {
                    context.startActivity(new Intent(context, Switch_btn_output.class));
                }

                if (childItem.getChildItemTitle().equals("ToggleButton")) {
                    context.startActivity(new Intent(context, Toggle_btn.class));
                } if (childItem.getChildItemTitle().equals("RadioButton")) {
                    context.startActivity(new Intent(context, Radio_btn.class));
                } if (childItem.getChildItemTitle().equals("RatingBar")) {
                    context.startActivity(new Intent(context, RatingBar.class));
                }  if (childItem.getChildItemTitle().equals("SeekBar")) {
                    context.startActivity(new Intent(context, SeekBar_output.class));
                }if (childItem.getChildItemTitle().equals("ProgressBar")) {
                    context.startActivity(new Intent(context, ProgressBar_output.class));
                }if (childItem.getChildItemTitle().equals("Spinner")) {
                    context.startActivity(new Intent(context, Spinner_output.class));
                }if (childItem.getChildItemTitle().equals("WebView")) {
                    context.startActivity(new Intent(context, WebView_output.class));
                }if (childItem.getChildItemTitle().equals("TimePicker")) {
                    context.startActivity(new Intent(context, TimePicker_output.class));
                }if (childItem.getChildItemTitle().equals("DataPicker")) {
                    context.startActivity(new Intent(context, DataPicker_output.class));
                }if (childItem.getChildItemTitle().equals("Alert Dialog")) {
                    context.startActivity(new Intent(context, AlertDialog_output.class));
                }

                if (childItem.getChildItemTitle().equals("Buttn")) {
                    Toast.makeText(context, "You Clicked om Button", Toast.LENGTH_SHORT).show();
                }


            });

        }
    }
}
