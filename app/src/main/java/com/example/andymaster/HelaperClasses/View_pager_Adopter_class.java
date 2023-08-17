package com.example.andymaster.HelaperClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.andymaster.R;

public class View_pager_Adopter_class extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    int []image_viewpager ={
            R.drawable.novelist_writing_bro_1,
            R.drawable.daco_196497,
            R.drawable.logomakerca_1679801187718

    };

    int [] strang_heading_view_adopter = {
            R.string.Heading_1,
            R.string.Heading_2,
            R.string.Heading_3
    };

    int [] strang_disc_view_adopter = {
            R.string.description_1,
            R.string.description_2,
            R.string.description_3
    };

    public View_pager_Adopter_class(Context context) {
        this.context= context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return strang_heading_view_adopter.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_adopter_onboarding_screen,container,false);
        ImageView img = view.findViewById(R.id.image_slider);
        img.setImageResource(image_viewpager[position]);
        TextView title = view.findViewById(R.id.textView2);
        title.setText(strang_heading_view_adopter[position]);
        TextView discription = view.findViewById(R.id.disc);
        discription.setText(strang_disc_view_adopter[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ConstraintLayout)object);
    }
}
