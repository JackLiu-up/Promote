package com.jackliu.promote.controller.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jackliu.promote.R;
import com.jackliu.promote.controller.adapter.ImageAdapter;
import com.jackliu.promote.model.bean.DataBean;
import com.jackliu.promote.model.bean.GoodsEntity;
import com.youth.banner.Banner;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private View view; //定义view用来设置fragment的layout
    Banner banner;

    private HomeViewModel mViewModel;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // 获取fragment的layout
        view = inflater.inflate(R.layout.home_fragment, container, false);

        return view;
        // return inflater.inflate(R.layout.home_fragment, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

}
