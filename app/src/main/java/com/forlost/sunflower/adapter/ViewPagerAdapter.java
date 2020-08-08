/*
package com.forlost.sunflower.adapter;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.forlost.sunflower.ui.fragment.HomeFragment;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

*/
/**
 * home页广告轮播图
 *//*

public class ViewPagerAdapter extends PagerAdapter {
    private List<ImageView> images;
    private int[] imageIds = new int[]{};
    private ViewPager viewPager;
    private ScheduledExecutorService scheduledExecutorService;
    private int currentItem;

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
// TODO Auto-generated method stub
//          super.destroyItem(container, position, object);
//          view.removeView(view.getChildAt(position));
//          view.removeViewAt(position);
        view.removeView(images.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
// TODO Auto-generated method stub
        view.addView(images.get(position));
        return images.get(position);
    }




}*/
