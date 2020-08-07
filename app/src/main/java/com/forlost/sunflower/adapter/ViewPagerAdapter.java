package com.forlost.sunflower.adapter;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ViewPagerAdapter extends PagerAdapter {
    private List<ImageView> images;
    private ViewPager mViewPaper;
    private ScheduledExecutorService scheduledExecutorService;
    private int currentItem;

    @Override
    public int getCount() {
        //无限循环

        return 1000;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup viewGroup, int position, @NonNull Object object) {
        //   super.destroyItem(container, position, object);
        viewGroup.removeView(images.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int position) {
        //  return super.instantiateItem(container, position);
        viewGroup.addView(images.get(position));
        return images.get(position);
    }


   /* *//**
     * 利用线程池定时执行动画轮播
     *//*

    public void onStart() {
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS); //修改时间改变轮播时间
    }

    *//**
     * 图片轮播任务
     *//*

    private class ViewPageTask implements Runnable {
        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);
        }
    }

    *//**
     * 接收子线程传递过来的数据
     *//*

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
        }

        ;
    };

    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }*/
}
