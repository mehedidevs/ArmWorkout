package com.example.armworkout.ViewpagerAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.armworkout.R;


public class ViewPagerAdapter2 extends PagerAdapter {

    public Context mContext;
    public LayoutInflater layoutInflater;

    public int [] imageArray = {R.drawable.to_image2,R.drawable.to_image3,R.drawable.top_image4,R.drawable.to_image5 };


    public ViewPagerAdapter2(Context mContext) {
        this.mContext = mContext;

    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {



        layoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.row_layout,null);

        ImageView imageView = (ImageView)view.findViewById(R.id.myImage_view);
        imageView.setImageResource(imageArray[position]);

        ViewPager viewPager = (ViewPager)container;
        viewPager.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager viewPager = (ViewPager)container;
        View view = (View)object;
        viewPager.removeView(view);



    }
}
