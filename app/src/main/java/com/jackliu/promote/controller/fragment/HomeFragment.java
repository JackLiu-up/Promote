package com.jackliu.promote.controller.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.jackliu.promote.R;
import com.jackliu.promote.controller.adapter.ImageAdapter;
import com.jackliu.promote.controller.adapter.TopAdapter;
import com.jackliu.promote.model.bean.DataBean;
import com.jackliu.promote.model.bean.GoodsEntity;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private View view; //定义view用来设置fragment的layout
    public RecyclerView topRecyclerView; //定义recyclerview
    //定义实体类为对象的数据集合
    private ArrayList<GoodsEntity> goodsEntityList = new ArrayList<GoodsEntity>();
    private TopAdapter topAdapter;
    public RecyclerView messageView;

    private HomeViewModel mViewModel;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // 获取fragment的layout
        view = inflater.inflate(R.layout.home_fragment, container, false);
        // 对recyclerview进行配置
        initRecyclerView();
        // 模拟数据
        initData();
        return view;
        // return inflater.inflate(R.layout.home_fragment, container, false);
    }

    /**
     * 模拟数据
     */
    private void initData() {
        for (int i = 0; i < 10; i++) {
            GoodsEntity goodsEntity = new GoodsEntity(" ");
             goodsEntity.setGoodsName("模拟数据"+i);
            //  goodsEntity.setGoodsPrice("100"+i);
            goodsEntityList.add(goodsEntity);
        }

    }

    private void initRecyclerView() {

        /**
         * 第一列视图
         */

        //获取RecyclerView
        topRecyclerView = (RecyclerView) view.findViewById(R.id.top_img_view);
        //创建adapter
        topAdapter = new TopAdapter(getActivity(), goodsEntityList);
        //给RecyclerView设置adapter
        topRecyclerView.setAdapter(topAdapter);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        topRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        //设置item的分割线
        topRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
        //RecyclerView中没有item的监听事件，需要自己在适配器中写一个监听事件的接口。参数根据自定义
        topAdapter.setOnItemClickListener(new TopAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, GoodsEntity data) {
                //此处进行监听事件的业务处理
                Toast.makeText(getActivity(), "您点击了图片", Toast.LENGTH_SHORT).show();
            }
        });

        //第二列视图
        messageView = view.findViewById(R.id.message_view);
        topAdapter = new TopAdapter(getActivity(), goodsEntityList);
        //给RecyclerView设置adapter
        messageView.setAdapter(topAdapter);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        messageView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        //设置item的分割线
        messageView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
        //RecyclerView中没有item的监听事件，需要自己在适配器中写一个监听事件的接口。参数根据自定义
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

}
