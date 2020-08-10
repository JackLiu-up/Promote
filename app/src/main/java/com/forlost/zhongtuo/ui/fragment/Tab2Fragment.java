package com.forlost.zhongtuo.ui.fragment;

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

import com.forlost.zhongtuo.R;
import com.forlost.zhongtuo.adapter.Tab2Adapter;
import com.forlost.zhongtuo.bean.Task;

import java.util.ArrayList;

public class Tab2Fragment extends Fragment {

    private Tab2ViewModel mViewModel;

    private View view;//定义view用来设置fragment的layout
    private RecyclerView tabView;
    //定义实体类对象的数据集合
    private ArrayList<Task> taskList = new ArrayList<Task>();
    //自定义任务列表recyclerview的适配器
    private Tab2Adapter adapter;

    public static Tab2Fragment newInstance() {
        return new Tab2Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab2_fragment, container, false);
        initRecyclerView();
        //模拟数据
        initData();
        return view;
    }

    //模拟数据
    private void initData() {
        for (int i = 0; i < 10; i++) {
            Task task = new Task();
            task.setMoney(0.5 + i);
            task.setLevel("众拓任务"+i);
            task.setTitle("众拓标题" + i);
            task.setType("众拓助力" + i);
            task.setElseCount(100 - (20 + i));
            task.setFinishCount(20 + i);
            taskList.add(task);
        }
    }

    /**
     * 对recyclerview进行配置
     */

    private void initRecyclerView() {
        //获取recycelerview
        tabView = view.findViewById(R.id.tab2);
        //创建adapter
        adapter = new Tab2Adapter(getActivity(),taskList);
        //给recyclerview设置adapter
        tabView.setAdapter(adapter);
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        tabView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //设置item的分割线
        tabView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        //RecyclerView中没有item的监听事件，需要自己在适配器中写一个监听事件的接口。参数根据自定义
        adapter.setOnItemClickListener(new Tab2Adapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Task data) {
                //此处进行监听事件的业务处理
                Toast.makeText(getActivity(), "我是众拓港", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(Tab2ViewModel.class);
        // TODO: Use the ViewModel
    }

}