package com.forlost.zhongtuo.ui.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.forlost.zhongtuo.R;
import com.forlost.zhongtuo.activity.LoginActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MineFragment extends Fragment {

    private MineViewModel mViewModel;
    private TextView gotoLogin;
    private TabLayout tabLayout;
    private ViewPager viewpager;
    ArrayList fragmentList = new ArrayList<Fragment>();
    String[] temp = {"任务", "游戏","消息","帮助","客服"};
    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

       final View view  = inflater.inflate(R.layout.mine_fragment, container, false);
        gotoLogin =  view.findViewById(R.id.goto_login);
        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),LoginActivity.class));
            }
        });
        tabLayout = view.findViewById(R.id.my_tab);
        viewpager = view.findViewById(R.id.teamvewpager);
        return view;
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
        fragmentList.add(new Team1Fragment());
        fragmentList.add(new Team2Fragment());
        fragmentList.add(new Team3Fragment());
        fragmentList.add(new Team4Fragment());
        fragmentList.add(new Team5Fragment());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MineViewModel.class);
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