package com.forlost.sunflower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forlost.sunflower.R;
import com.forlost.sunflower.bean.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务列表适配器
 */
public class TaskRecycleViewAdapter extends RecyclerView.Adapter<TaskRecycleViewAdapter.myViewHodler> {
    private ArrayList<Task> myTaskList;
    private Context context;

    //创建构造函数
    public TaskRecycleViewAdapter(Context context, ArrayList<Task> myTaskList) {
        //将传递过来的数据，赋值给本地变量
        this.context = context;
        this.myTaskList = myTaskList; //实体类数据Arraylist
    }

    /**
     * 创建viewholder，相当于listview中的getview中的创建的view和viewhodler
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public myViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建自定义布局
        View itemView = View.inflate(context, R.layout.tab1, null);
        return new myViewHodler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskRecycleViewAdapter.myViewHodler holder, int position) {
        Task taskData = myTaskList.get(position);
        holder.task_type.setText(taskData.getType());
        holder.task_level.setText(taskData.getLevel());
        holder.title.setText(taskData.getTitle());
        holder.finish_count.setText(taskData.getFinishCount()+"");
        holder.else_count.setText(taskData.getElseCount()+"");
        holder.task_money.setText((int) taskData.getMoney()+"");
    }

    //得到总条数
    @Override
    public int getItemCount() {
        return myTaskList.size();
    }

    //自定义viewHodler
    class myViewHodler extends RecyclerView.ViewHolder {
        private ImageView taskActor;
        private TextView title, task_money, task_level, task_type, finish_count, else_count;

        public myViewHodler(View itemView) {
            super(itemView);
            taskActor = itemView.findViewById(R.id.actor);
            title = itemView.findViewById(R.id.title);
            task_level = itemView.findViewById(R.id.task_level);
            task_type = itemView.findViewById(R.id.task_type);
            task_money = itemView.findViewById(R.id.task_money);
            finish_count = itemView.findViewById(R.id.finish_count);
            else_count = itemView.findViewById(R.id.else_count);
            //点击事件放在adapter中使用，也可以写个接口在activity中调用
            //方法一：在adapter中设置点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //可以选择直接在本位置直接写业务处理
                    //Toast.makeText(context,"点击了xxx",Toast.LENGTH_SHORT).show();
                    //此处回传点击监听事件
                    if (onItemClickListener != null) {
                        onItemClickListener.OnItemClick(v, myTaskList.get(getLayoutPosition()));

                    }

                }

            });

        }
    }

    /**
     * 设置item的监听事件的接口
     */

    public interface OnItemClickListener {

        /**
         * 接口中的点击每一项的实现方法，参数自己定义
         *
         * @param view 点击的item的视图
         * @param data 点击的item的数据
         */
        public void OnItemClick(View view, Task data);

    }


    //需要外部访问，所以需要设置set方法，方便调用
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;

    }
}
