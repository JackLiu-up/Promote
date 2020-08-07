package com.forlost.sunflower.ui.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.forlost.sunflower.R;
import com.forlost.sunflower.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private View mView;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;
    private ViewPager mViewPaper;
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

    private ListView listView;
    SimpleAdapter simpleAdapter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.home_fragment, container, false);
        listView = mView.findViewById(R.id.listView);
        simpleAdapter = new SimpleAdapter(getActivity(),getData(),R.layout.listview,new String[]{"title","image"},new int[]{R.id.myMenu_name,R.id.myMenu_image});
        listView.setAdapter(simpleAdapter);
        // listView.setOnItemClickListener(this);
        //    setView();
        return mView;
    }

    private List<Map<String,Object>> getData() {
        String [] titles={"水果1","水果2","水果3","水果4","水果5","水果6","水果7"};
        int [] images={R.drawable.flute,R.drawable.flute,R.drawable.flute,
                R.drawable.flute,R.drawable.flute,
                R.drawable.flute,R.drawable.flute};
        List<Map<String,Object>> list= new ArrayList<>();
        for(int i=0;i<7;i++){
            Map  map = new HashMap();
            map.put("title",titles[i]);
            map.put("image",images[i]);
            list.add(map);
        }
        return list;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }



    private void setView() {
        mViewPaper = mView.findViewById(R.id.viewPager);
        //显示图片
        images = new ArrayList<ImageView>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(mView.findViewById(R.id.dot_0));
        dots.add(mView.findViewById(R.id.dot_1));
        dots.add(mView.findViewById(R.id.dot_2));
        dots.add(mView.findViewById(R.id.dot_3));
        dots.add(mView.findViewById(R.id.dot_4));

        adapter = new ViewPagerAdapter();

        mViewPaper.setAdapter(adapter);
        mViewPaper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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


}
