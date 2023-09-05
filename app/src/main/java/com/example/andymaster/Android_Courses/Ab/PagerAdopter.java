package com.example.andymaster.Android_Courses.Ab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.andymaster.R;

import java.util.List;

public class PagerAdopter   extends PagerAdapter {

    private Context context;
    private List<TutorialPage> tutorialPages;

    public PagerAdopter(Context context, List<TutorialPage> tutorialPages) {
        this.context = context;
        this.tutorialPages = tutorialPages;
    }

    public boolean onTouchEvent(MotionEvent event) {
        // Disable smooth scrolling by returning false
        return false;
    }

    @Override
    public int getCount() {
        return tutorialPages.size();
    }

    ImageView imageView;


    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.intro_android_adopter,container,false);

        imageView = itemView.findViewById(R.id.tutorialImage);
        TextView textView = itemView.findViewById(R.id.tutorialText);
        ProgressBar progressBar = itemView.findViewById(R.id.progressBar);

        TutorialPage page = tutorialPages.get(position);
        imageView.setImageResource(page.getImageResource());
        textView.setText(page.getText());
        progressBar.setProgress(page.getProgress());

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
