package com.forlost.sunflower.ui.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.forlost.sunflower.R;
import com.forlost.sunflower.adapter.RecyclerViewAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HomeFragment extends Fragment {

    /**
     * @author liujie
     * 2020.08.08
     */

    private HomeViewModel contentViewModel;
    private View contentView;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;
    private ViewPager viewPager;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;

    //存放图片的id，可以根据自己的需求进行修改
    private int[] imageIds = new int[]{
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9
    };
    private RecyclerView recyclerView;
    private List<String> list;
    private Context context;
    private RecyclerViewAdapter recyclerViewAdapter;

    SimpleAdapter simpleAdapter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.home_fragment, container, false);
        context = contentView.getContext();
        recyclerView = contentView.findViewById(R.id.recyclerview);
        list = new ArrayList<String>();
        initData();
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewAdapter = new RecyclerViewAdapter(context, list);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));//添加下划线

        setView();//顶部轮播图广告，打开注释会闪退

        return contentView;
    }

    /**
     * 列表数据
     */
    private void initData() {
        list.add("好消息！8月8日有5例确诊患者、3例无症状感染者出院");
        list.add("美国罗斯福号航母三名选手确诊");
        list.add("缅甸首次出现新冠肺炎病例");
        list.add("韩国抗议措施收到成效");
        list.add("西班牙死亡人数创新高");
        list.add("古巴限制外国游客进入");
        list.add("意大利死亡人数已达全球最高");
        list.add("美国关闭边境以限制非必要的出行");
        list.add("各国采取更严厉的措施应对新冠病毒");
        list.add("新冠病毒引发经济危机");
        list.add("新冠病毒肆虐欧洲各国");
        list.add("欧洲多国封锁边境");
        list.add("意大利死亡人数已达全球最高");
        list.add("美国关闭边境以限制非必要的出行");
        list.add("各国采取更严厉的措施应对新冠病毒");
        list.add("新冠病毒引发经济危机");
        list.add("新冠病毒肆虐欧洲各国");
        list.add("欧洲多国封锁边境");
        list.add("意大利死亡人数已达全球最高");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        contentViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }


    private void setView() {
        viewPager = contentView.findViewById(R.id.viewPager);
        //显示图片
        images = new ArrayList<ImageView>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(contentView.findViewById(R.id.dot_0));
        dots.add(contentView.findViewById(R.id.dot_1));
        dots.add(contentView.findViewById(R.id.dot_2));
        dots.add(contentView.findViewById(R.id.dot_3));
        dots.add(contentView.findViewById(R.id.dot_4));

        adapter = new ViewPagerAdapter();

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                dots.get(position).setBackgroundResource(R.drawable.dot);
                dots.get(oldPosition).setBackgroundResource(R.drawable.dot2);
                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    /*定义广告轮播图的适配器*/
   public class ViewPagerAdapter extends PagerAdapter {
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
    }


    /**
     * 利用线程池定时执行动画轮播
     */

    @Override
    public void onStart() {
// TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
    }
//此处可以修改数字，改变轮播定时时间


    /**
     * 接收子线程传递过来的数据
     */

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            viewPager.setCurrentItem(currentItem);
        }

        ;
    };

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }

    /**
     * 图片轮播任务
     */

    private class ViewPageTask implements Runnable {
        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);
        }
    }
}
