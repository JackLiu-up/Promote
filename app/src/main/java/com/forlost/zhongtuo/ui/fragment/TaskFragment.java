package com.forlost.zhongtuo.ui.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.forlost.zhongtuo.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TaskFragment extends Fragment {
    private View contextView;// 总视图
    private TaskViewModel mViewModel;
    private TabLayout tabLayout;
    private ViewPager viewpager;
    ArrayList fragmentList = new ArrayList<Fragment>();
    String[] temp = {"自由港", "众拓港"};

    //悬浮按钮
    private Button fab;

    public static TaskFragment newInstance() {
        return new TaskFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        contextView = inflater.inflate(R.layout.task_fragment, container, false);
        tabLayout = contextView.findViewById(R.id.tabLayout);
        viewpager = contextView.findViewById(R.id.taskViewPager);
        return contextView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        // fragment中嵌套fragment, Manager需要用(getChildFragmentManager())

        MPagerAdapter mPagerAdapter = new MPagerAdapter(getChildFragmentManager());

        initFragment();

        tabLayout.setupWithViewPager(viewpager);
        viewpager.setAdapter(mPagerAdapter);

    }

    private void initFragment() {
        fragmentList.add(new Tab1Fragment());
        fragmentList.add(new Tab2Fragment());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TaskViewModel.class);
        // TODO: Use the ViewModel
    }

    class MPagerAdapter extends FragmentPagerAdapter {
        public MPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return (Fragment) fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        //返回tablayout的标题文字;
        @Override
        public CharSequence getPageTitle(int position) {
            return temp[position];
        }

    }
}
